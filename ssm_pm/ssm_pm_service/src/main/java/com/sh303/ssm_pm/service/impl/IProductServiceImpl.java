package com.sh303.ssm_pm.service.impl;

import com.github.pagehelper.PageHelper;
import com.sh303.ssm_pm.dao.IProductDao;
import com.sh303.ssm_pm.entity.Product;
import com.sh303.ssm_pm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao iProductDao;

    /**
     * 分页查询全部商品
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<Product> findAll(Integer pageNum, Integer pageSize) throws Exception {
        // 参数pageNum 是页码值  参数pageSize 是每页显示条数
        PageHelper.startPage(pageNum, pageSize);
        return iProductDao.findAll();
    }

    /**
     * 添加单条产品
     *
     * @param product
     * @throws Exception
     */
    @Override
    public void save(Product product) throws Exception {
        iProductDao.save(product);
    }

}
