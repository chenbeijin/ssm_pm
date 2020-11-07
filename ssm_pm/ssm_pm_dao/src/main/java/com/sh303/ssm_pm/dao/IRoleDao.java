package com.sh303.ssm_pm.dao;

import com.sh303.ssm_pm.entity.Permission;
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

    /**
     * 查询所有角色
     *
     * @return
     */
    @Select("select * from role")
    public List<Role> findAll() throws Exception;

    /**
     * 添加单条角色
     *
     * @param role
     * @throws Exception
     */
    @Insert("insert into role(id, roleName, roleDesc) values(null, #{roleName}, #{roleDesc})")
    public void save(Role role) throws Exception;

    /**
     * 查询单条角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissionList", column = "id", javaType = java.util.List.class, many = @Many(select = "com.sh303.ssm_pm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public Role findById(Integer id) throws Exception;

    /**
     * 根据角色id删除用户和角色中间表有联系的数据
     *
     * @param roleId
     */
    @Delete("delete from users_role where roleId = #{roleId}")
    public void deleteFromUser_RoleByRoleId(Integer roleId);

    /**
     * 根据角色id删除角色和权限中间表有联系的数据
     *
     * @param roleId
     * @throws Exception
     */
    @Delete("delete from role_permission where roleId = #{roleId}")
    public void deleteFromRole_PermissionByRoleId(Integer roleId) throws Exception;

    /**
     * 根据角色id删除角色
     *
     * @param roleId
     * @throws Exception
     */
    @Delete("delete from role where id = #{roleId}")
    public void deleteRoleById(Integer roleId) throws Exception;

    /**
     * 查询角色未添加的权限
     *
     * @param roleId
     * @return
     */
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    public List<Permission> findOtherPermission(Integer roleId) throws Exception;
}
