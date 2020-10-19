package com.sh303.ssm_pm.dao;

import com.sh303.ssm_pm.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {

    /**
     * 根据用户id查询出所有对应的角色
     * @param uid
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleId from users_role where usersId = #{uid})")
    public List<Role> findByUid(String uid) throws Exception;
}
