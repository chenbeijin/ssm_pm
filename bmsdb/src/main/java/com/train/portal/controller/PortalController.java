package com.train.portal.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.train.base.controller.BaseController;
import com.train.base.view.JsonView;
import com.train.portal.biz.IPortalBiz;
import com.train.security.entity.SysMenu;
import com.train.security.entity.SysRole;
import com.train.security.entity.SysUser;
import com.train.security.model.MenuModel;
import com.train.util.AESUtil;
import com.train.util.ImageUtil;
import com.train.util.Md5Util;

/**
 * 业务控制层<br>
 * <p>
 * 导航控制器
 *
 * @author Tong Baojun
 */
@Controller
@RequestMapping("/portal.do")
@Scope("prototype")
public class PortalController extends BaseController {
    @Autowired
    private IPortalBiz portalBiz;
    private static String sKey = "XfLy8g7qjmnbgEsB";// 协同提供的加密解密key

    /**
     * 产生随机验证码
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "action=handleRnd")
    public void handleRnd(HttpServletRequest request,
                          HttpServletResponse response) throws Exception {
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0L);
        response.setContentType("image/jpeg");
        BufferedImage image = new BufferedImage(65, 25,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 65, 25);
        g.setColor(Color.yellow);
        Font font = new Font("宋体", Font.BOLD, 20);
        g.setFont(font);
        Random r = new Random();
        String rnd = "";
        int ir = r.nextInt(10);
        rnd = rnd + "" + ir;
        g.drawString("" + ir, 5, 18);
        g.setColor(Color.red);
        ir = r.nextInt(10);
        rnd = rnd + "" + ir;
        g.drawString("" + ir, 20, 18);
        g.setColor(Color.blue);
        ir = r.nextInt(10);
        rnd = rnd + "" + ir;
        g.drawString("" + ir, 35, 18);
        g.setColor(Color.green);
        ir = r.nextInt(10);
        rnd = rnd + "" + ir;
        g.drawString("" + ir, 50, 18);
        request.getSession().setAttribute("RND", rnd);
        ServletOutputStream out = response.getOutputStream();
        out.write(ImageUtil.imageToBytes(image, "gif"));
        out.flush();
        out.close();
    }

    /**
     * 软件登陆页面
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "action=logon")
    public ModelAndView logon(ModelMap model, String sessionKey)
            throws Exception {
        model.put("sessionKey", sessionKey);
        return new ModelAndView("portal/logon");
    }

    /**
     * 用户登陆验证
     *
     * @param request
     * @param usrName
     * @param usrPwd
     * @param usrRnd
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "action=validate")
    public JsonView validate(HttpServletRequest request, String usrName,
                             String usrPwd, String usrRnd) throws Exception {
        JsonView view = new JsonView();
        try {
            String sessionRND = (String) request.getSession().getAttribute(
                    "RND");
            if (sessionRND.equals(usrRnd)) {
                SysUser user = portalBiz.findUserByUserCodeOrNickName(usrName);
                if (user == null) {
                    view.setProperty("result", "error");
                    view.setProperty("message", "用户名不存在");
                } else {
                    if (user.getUserPwd().equals(Md5Util.md5(usrPwd))
                            || user.getUserPwd().equals(
                            AESUtil.encrypt(usrPwd, sKey))) {
                        request.getSession().setAttribute("USER", user);
                        request.getSession().setAttribute("USERNAME",
                                user.getUserName());
                        view.setProperty("result", "succ");
                    } else {
                        view.setProperty("result", "error");
                        view.setProperty("message", "用户名和密码不匹配");
                    }
                }
            } else {
                view.setProperty("result", "error");
                view.setProperty("message", "验证码输入错误");
            }
        } catch (Exception ex) {
            view.setProperty("result", "error");
            view.setProperty("message", ex.getMessage());
        }
        return view;
    }

    /**
     * 无验证码登陆
     *
     * @param request
     * @param usrName
     * @param usrPwd
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "action=validateUser")
    public ModelAndView validateUser(HttpServletRequest request,
                                     String usrNickName, String usrPwd) throws Exception {
        try {
            SysUser user = portalBiz.findUserByUserCodeOrNickName(usrNickName);
            if (user == null) {
                throw new Exception("用户不存在，请联系管理员");
            } else {
                if (user.getUserPwd().equals(Md5Util.md5(usrPwd))
                        || user.getUserPwd().equals(usrPwd)) {
                    request.getSession().setAttribute("USER", user);
                    request.getSession().setAttribute("USERNAME",
                            user.getUserName());
                    return new ModelAndView("portal/portalIndex");
                } else {
                    throw new Exception("用户名和密码不匹配,请联系管理员");
                }
            }
        } catch (Exception ex) {
            throw new Exception("无法登陆,请联系管理员");
        }
    }

    /**
     * 用户退出
     *
     * @param request
     * @param uuId
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "action=logonOut")
    public ModelAndView logonOut(HttpServletRequest request, ModelMap model,
                                 String sessionKey) throws Exception {
        request.getSession().removeAttribute("USER");
        return this.logon(model, sessionKey);
    }

    /**
     * 软件主界面
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "action=index")
    public ModelAndView index(HttpServletRequest request, ModelMap model,
                              String sessionKey) throws Exception {
        SysUser user = (SysUser) this.getLoginUser(request);
        if (user == null) {
            return this.logon(model, request.getSession().getId());
        } else {
            if (sessionKey == null) {
                return this.logon(model, request.getSession().getId());
            } else {
                return new ModelAndView("portal/portalIndex");
            }
        }
    }

    /**
     * 顶部
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "action=portalTop")
    public ModelAndView portalTop(HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", (SysUser) this.getLoginUser(request));
        map.put("sessionKey", request.getSession().getId());
        map.put("licMsg", "");
        return new ModelAndView("portal/portalTop", map);
    }

    /**
     * 左边菜单
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(params = "action=portalLeft")
    public ModelAndView portalBottom(HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        SysUser user = (SysUser) this.getLoginUser(request);
        Collection<SysRole> rolelist = portalBiz.findRolesByUserCode(user
                .getUserCode());

        rolelist = portalBiz.findRolesByUserCode(user.getUserCode());

        // 用户对应的所有菜单
        HashMap<Long, SysMenu> totalMenuList = new HashMap<Long, SysMenu>();
        // 用户对应的一级菜单
        TreeMap<Long, SysMenu> firstMenuMap = new TreeMap<Long, SysMenu>();
        // 用户对应角色的所有菜单求交集
        for (SysRole role : rolelist) {
            Collection<SysMenu> menulist = portalBiz.findMenusByListId(role
                    .getRoleMenus());
            for (SysMenu menu : menulist) {
                totalMenuList.put(menu.getMenuId(), menu);
                if (menu.getMenuGrade() == 1) {
                    firstMenuMap.put(menu.getMenuOrder(), menu);
                }
            }
        }
        // ===========================================
        String strTotalMenusIds = "-1";
        Iterator iterTotal = totalMenuList.entrySet().iterator();
        while (iterTotal.hasNext()) {
            Map.Entry entry = (Map.Entry) iterTotal.next();
            SysMenu menu = (SysMenu) entry.getValue();
            strTotalMenusIds = strTotalMenusIds + "," + menu.getMenuId();
        }
        // ============================================
        Iterator iter = firstMenuMap.entrySet().iterator();
        ArrayList<SysMenu> menulist = new ArrayList<SysMenu>();
        // 初始化一级菜单
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            SysMenu menu1 = (SysMenu) entry.getValue();
            MenuModel menuModel1 = new MenuModel();
            menuModel1.setMenuId(menu1.getMenuId());
            menuModel1.setMenuName(menu1.getMenuName());
            menuModel1.setMenuURL(menu1.getMenuURL());
            menuModel1.setMenuParentId(menu1.getMenuParentId());
            menuModel1.setMenuGrade(menu1.getMenuGrade());
            menuModel1.setMenuTarget(menu1.getMenuTarget());
            // ----------------------------------------------------------
            // 初始化二级菜单
            Collection<SysMenu> menu2list = portalBiz.findAllChildMenus(
                    menu1.getMenuId(), strTotalMenusIds);
            if (menu2list != null) {
                ArrayList<MenuModel> menu2RetList = new ArrayList<MenuModel>();
                for (SysMenu menu2 : menu2list) {
                    MenuModel menuModel2 = new MenuModel();
                    menuModel2.setMenuId(menu2.getMenuId());
                    menuModel2.setMenuName(menu2.getMenuName());
                    menuModel2.setMenuURL(menu2.getMenuURL());
                    menuModel2.setMenuParentId(menu2.getMenuParentId());
                    menuModel2.setMenuGrade(menu2.getMenuGrade());
                    menuModel2.setMenuTarget(menu2.getMenuTarget());
                    // 初始化三级菜单
                    Collection<SysMenu> menu3list = portalBiz
                            .findAllChildMenus(menu2.getMenuId(),
                                    strTotalMenusIds);
                    if (menu3list != null) {
                        ArrayList<MenuModel> menu3RetList = new ArrayList<MenuModel>();
                        for (SysMenu menu3 : menu3list) {
                            MenuModel menuModel3 = new MenuModel();
                            menuModel3.setMenuId(menu3.getMenuId());
                            menuModel3.setMenuName(menu3.getMenuName());
                            menuModel3.setMenuURL(menu3.getMenuURL());
                            menuModel3.setMenuParentId(menu3.getMenuParentId());
                            menuModel3.setMenuGrade(menu3.getMenuGrade());
                            menuModel3.setMenuTarget(menu3.getMenuTarget());
                            menu3RetList.add(menuModel3);
                        }
                        menuModel2.setChildMenuList(menu3RetList);
                    }
                    menu2RetList.add(menuModel2);
                }
                menuModel1.setChildMenuList(menu2RetList);
            }
            // ----------------------------------------------------------
            menulist.add(menuModel1);
        }
        map.put("menulist", menulist);
        return new ModelAndView("portal/portalLeft", map);
    }

    /**
     * 用户桌面
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "action=portalRight")
    public ModelAndView portalleft(HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        return new ModelAndView("portal/portalRight", map);
    }

    /**
     * 修改用户密码
     *
     * @param request
     * @param uuId
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "action=modifyUsrPwd")
    public ModelAndView modifyUsrPwd(HttpServletRequest request, String uuId)
            throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", portalBiz.findUserById(Integer.parseInt(uuId)));
        return new ModelAndView("portal/modUserPwd", map);
    }

    /**
     * 修改用户密码
     *
     * @param request
     * @param uuId
     * @param userNewPwd
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "action=updateUserPwd")
    public JsonView updateUserPwd(HttpServletRequest request, String uuId,
                                  String userNewPwd) throws Exception {
        JsonView view = new JsonView();
        try {
            portalBiz.updateUserPwd(Integer.parseInt(uuId), userNewPwd);
            view.setProperty("result", "succ");
        } catch (Exception ex) {
            ex.printStackTrace();
            view.setProperty("result", "error");
        }
        return view;
    }
}
