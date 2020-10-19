package com.sh303.ssm_pm.service;

import com.sh303.ssm_pm.entity.Orders;

import java.util.List;

public interface IOrdersService {

    /**
     * 分页查询全部订单
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<Orders> findAdd(Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 查询单条订单
     *
     * @param id
     * @return
     * @throws Exception
     */
    Orders findById(String id) throws Exception;
}
