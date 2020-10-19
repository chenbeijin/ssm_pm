package com.sh303.ssm_pm.dao;

import com.sh303.ssm_pm.entity.Member;
import com.sh303.ssm_pm.entity.Orders;
import com.sh303.ssm_pm.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao {

    /**
     * 查询全部订单
     *
     * @return
     * @throws Exception
     */
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.sh303.ssm_pm.dao.IProductDao.findById"))
    })
    List<Orders> findAdd() throws Exception;

    /**
     * 查询单条订单
     *
     * @param ordersId
     * @return
     * @throws Exception
     */
    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.sh303.ssm_pm.dao.IProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "com.sh303.ssm_pm.dao.IMemberDao.findById")),
            @Result(property = "travellerList", column = "id", javaType = java.util.List.class, many = @Many(select = "com.sh303.ssm_pm.dao.ITravellerDao.findByOid"))
    })
    Orders findById(String ordersId) throws Exception;
}
