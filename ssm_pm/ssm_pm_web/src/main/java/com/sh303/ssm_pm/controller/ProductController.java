package com.sh303.ssm_pm.controller;

import com.github.pagehelper.PageInfo;
import com.sh303.ssm_pm.entity.Product;
import com.sh303.ssm_pm.service.IProductService;
import com.sh303.ssm_pm.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    /**
     * 跳转到添加页面
     *
     * @return
     */
    @GetMapping("/add.to")
    public ModelAndView toAdd() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product-add");
        return modelAndView;
    }

    /**
     * 分页查询所有产品
     *
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", required = true, defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = null;
        try {
            productList = iProductService.findAll(pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // PageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(productList);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("product-page-list");
        return modelAndView;
    }

    /**
     * 添加单条产品
     *
     * @param product
     * @return
     */
    @PostMapping("/save.do")
    public String save(Product product) {
        try {
            product.setId(UuidUtils.getUuid());
            iProductService.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

}
