package com.sh303.ssm_pm.dao;

import com.sh303.ssm_pm.entity.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {

    /**
     * 根据Oid 查询旅客
     *
     * @param orderId
     * @return
     * @throws Exception
     */
    @Select("select * from traveller where id = (select travellerId from order_traveller where orderId = #{orderId})")
    List<Traveller> findByOid(String orderId) throws Exception;

}
