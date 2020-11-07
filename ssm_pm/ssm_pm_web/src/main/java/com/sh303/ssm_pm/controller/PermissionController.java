package com.sh303.ssm_pm.controller;

import com.github.pagehelper.PageInfo;
import com.sh303.ssm_pm.entity.Permission;
import com.sh303.ssm_pm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService iPermissionService;

    /**
     * 跳转到添加权限页面
     *
     * @return
     */
    @RequestMapping("/add.to")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView toAdd() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("permission-add");
        return modelAndView;
    }

    /**
     * 查询所有权限
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAll")
    @PreAuthorize("authentication.principal.username == 'tom'")
    public ModelAndView findAll(@RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", required = true, defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissionList = null;
        try {
            permissionList = iPermissionService.findAll(pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageInfo pageInfo = new PageInfo(permissionList);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("permission-page-list");
        return modelAndView;
    }

    /**
     * 添加单条权限
     *
     * @param permission
     * @return
     */
    @RequestMapping("/save.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String save(Permission permission) {
        try {
            iPermissionService.save(permission);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

    /**
     * 查询单条权限
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(value = "id", required = true) Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Permission permission = null;
        try {
            permission = iPermissionService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("permission", permission);
        modelAndView.setViewName("permission-show");
        return modelAndView;
    }

    /**
     * 删除单条权限
     *
     * @param id
     * @return
     */
    @RequestMapping("/deletePermission.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deletePermission(@RequestParam(value = "id", required = true) Integer id) {
        try {
            iPermissionService.deletePermission(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }
}
