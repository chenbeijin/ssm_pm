package com.sh303.ssm_pm.controller;

import com.github.pagehelper.PageInfo;
import com.sh303.ssm_pm.entity.UserInfo;
import com.sh303.ssm_pm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) {
        try {
            userService.save(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

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
}
