package com.sh303.ssm_pm.dao;

import com.sh303.ssm_pm.entity.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {

    /**
     * 根据角色id查询所有对应的权限
     *
     * @param rid
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{rid})")
    public List<Permission> findPermissionByRoleId(Integer rid) throws Exception;
}
