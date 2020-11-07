package com.sh303.ssm_pm.controller;

import com.github.pagehelper.PageInfo;
import com.sh303.ssm_pm.entity.Orders;
import com.sh303.ssm_pm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService iOrdersService;

    /**
     * 跳转到添加页面
     *
     * @return
     */
    @GetMapping("add.to")
    public ModelAndView toAdd() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orders-add");
        return modelAndView;
    }

    /**
     * 分页查询全部订单
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", required = true, defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> ordersList = null;
        try {
            ordersList = iOrdersService.findAll(pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // PageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(ordersList);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("orders-page-list");
        return modelAndView;
    }

    /**
     * 查询单条订单
     *
     * @param ordersId
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(value = "id", required = true) String ordersId) {
        ModelAndView modelAndView = new ModelAndView();
        Orders orders = null;
        try {
            orders = iOrdersService.findById(ordersId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("orders", orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }

}
