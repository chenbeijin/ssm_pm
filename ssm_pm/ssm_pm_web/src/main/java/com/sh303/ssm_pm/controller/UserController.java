package com.sh303.ssm_pm.controller;

import com.github.pagehelper.PageInfo;
import com.sh303.ssm_pm.entity.Role;
import com.sh303.ssm_pm.entity.UserInfo;
import com.sh303.ssm_pm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 跳转到添加页面
     *
     * @return
     */
    @RequestMapping("/add.to")
    @RolesAllowed("ADMIN")
    public ModelAndView toAdd() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", required = true, defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userInfoList = null;
        try {
            userInfoList = userService.findAll(pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageInfo pageInfo = new PageInfo(userInfoList);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("user-page-list");
        return modelAndView;
    }

    /**
     * 添加单个用户
     *
     * @param userInfo
     * @return
     */
    @RequestMapping("/save.do")
    @RolesAllowed("ADMIN")
    public String save(UserInfo userInfo) {
        try {
            userService.save(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

    /**
     * 查询单条用户
     *
     * @param uid
     * @return
     */
    @RequestMapping("/findByUid.do")
    public ModelAndView findById(@RequestParam(value = "id", required = true) Integer uid) {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = null;
        try {
            userInfo = userService.findById(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    /**
     * 根据id查询用户以及所有角色跳转到用户角色添加页面
     *
     * @param userId
     * @return
     */
    @RequestMapping("/findUserByIdAndAllRole.to")
    @RolesAllowed("ADMIN")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(value = "id", required = true) Integer userId) {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = null;
        List<Role> roleList = null;
        try {
            userInfo = userService.findById(userId);
            roleList = userService.findOtherRoles(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("user", userInfo);
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    /**
     * 用户添加角色
     *
     * @param usersId
     * @param ids
     * @return
     */
    @RequestMapping("/addRoleToUser.do")
    @RolesAllowed("ADMIN")
    public String addRoleToUser(Integer usersId, Integer[] ids) {
        try {
            userService.addRoleToUser(usersId, ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

    /**
     * 删除单条用户
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteUser.do")
    @RolesAllowed("ADMIN")
    public String delete(@RequestParam(value = "id", required = true) Integer id) {
        try {
            userService.deleteUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }
}
