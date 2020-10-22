package com.sh303.ssm_pm.dao;

import com.sh303.ssm_pm.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {

    /**
     * 查询全部产品
     *
     * @return
     */
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    /**
     * 添加产品
     *
     * @param product
     */
    @Insert("insert into product(id, productNum, productName, cityName, departureTime, productPrice, productDesc, productStatus) values(#{id}, #{productNum}, #{productName}, #{cityName}, #{departureTime}, #{productPrice}, #{productDesc}, #{productStatus})")
    public void save(Product product) throws Exception;

    /**
     * 根据id 查询产品
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from product where id = #{id}")
    public Product findById(String id) throws Exception;

}
