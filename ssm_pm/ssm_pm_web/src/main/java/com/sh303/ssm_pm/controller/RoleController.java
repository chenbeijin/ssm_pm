package com.sh303.ssm_pm.controller;

import com.github.pagehelper.PageInfo;
import com.sh303.ssm_pm.entity.Permission;
import com.sh303.ssm_pm.entity.Role;
import com.sh303.ssm_pm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    /**
     * 跳转到添加页面
     *
     * @return
     */
    @RequestMapping("add.to")
    @Secured("ROLE_ADMIN")
    public ModelAndView toAdd() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("role-add");
        return modelAndView;
    }

    /**
     * 查询所有角色
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", required = true, defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = null;
        try {
            roleList = iRoleService.findAll(pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageInfo pageInfo = new PageInfo(roleList);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("role-page-list");
        return modelAndView;
    }

    /**
     * 查询单条角色
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(value = "id", required = true) Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Role role = null;
        try {
            role = iRoleService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("role", role);
        modelAndView.setViewName("role-show");
        return modelAndView;
    }

    /**
     * 添加单条角色
     *
     * @return
     */
    @RequestMapping("/save.do")
    @Secured("ROLE_ADMIN")
    public String save(Role role) {
        try {
            iRoleService.save(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

    /**
     * 根据id查询角色以及所有权限跳转到添加角色权限页面
     *
     * @param roleId
     * @return
     */
    @RequestMapping("/findRoleByIdAndAllPermission.to")
    @Secured("ROLE_ADMIN")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(value = "id", required = true) Integer roleId) {
        ModelAndView modelAndView = new ModelAndView();
        Role role = null;
        List<Permission> permissionList = null;
        try {
            role = iRoleService.findById(roleId);
            permissionList = iRoleService.findOtherPermission(roleId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("role", role);
        modelAndView.addObject("permissionList", permissionList);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    @RequestMapping("/deleteRole.do")
    @Secured("ROLE_ADMIN")
    public String delete(@RequestParam(value = "id", required = true) Integer roleId) {
        try {
            iRoleService.deleteRoleById(roleId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }
}
