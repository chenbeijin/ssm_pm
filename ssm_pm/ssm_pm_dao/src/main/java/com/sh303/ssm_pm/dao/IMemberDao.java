package com.sh303.ssm_pm.dao;

import com.sh303.ssm_pm.entity.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {

    /**
     * 根据 id 查询会员
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from member where id = #{id}")
    public Member findById(String id) throws Exception;

}
