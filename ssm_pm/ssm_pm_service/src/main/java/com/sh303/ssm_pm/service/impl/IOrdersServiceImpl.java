package com.sh303.ssm_pm.service.impl;

import com.github.pagehelper.PageHelper;
import com.sh303.ssm_pm.dao.IOrdersDao;
import com.sh303.ssm_pm.entity.Orders;
import com.sh303.ssm_pm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IOrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao iOrdersDao;

    /**
     * 分页查询全部订单
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public List<Orders> findAdd(Integer pageNum, Integer pageSize) throws Exception {
        // 参数pageNum 是页码值  参数pageSize 是每页显示条数
        PageHelper.startPage(pageNum, pageSize);
        return iOrdersDao.findAdd();
    }

    /**
     * 查询单条订单
     *
     * @param ordersId
     * @return
     * @throws Exception
     */
    @Override
    public Orders findById(String ordersId) throws Exception {
        return iOrdersDao.findById(ordersId);
    }

}
