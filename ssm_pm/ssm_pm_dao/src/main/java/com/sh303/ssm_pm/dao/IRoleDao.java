package com.sh303.ssm_pm.dao;

import com.sh303.ssm_pm.entity.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {

    /**
     * 根据用户id查询出所有对应的角色
     *
     * @param uid
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleId from users_role where usersId = #{uid})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissionList", column = "id", javaType = java.util.List.class, many = @Many(select = "com.sh303.ssm_pm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(Integer uid) throws Exception;
}
