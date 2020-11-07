package com.sh303.ssm_pm.service;

import com.sh303.ssm_pm.entity.Product;

import java.util.List;

public interface IProductService {

    /**
     * 分页查询全部产品
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<Product> findAll(Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 添加单条产品
     *
     * @param product
     * @throws Exception
     */
    public void save(Product product) throws Exception;

}
