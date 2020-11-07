package com.sh303.ssm_pm.dao;

import com.sh303.ssm_pm.entity.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

    /**
     * 查询所有权限
     *
     * @return
     */
    @Select("select * from permission")
    public List<Permission> findAll() throws Exception;

    /**
     * 添加单条权限
     *
     * @param permission
     * @throws Exception
     */
    @Insert("insert into permission(id, permissionName, url) values(null, '${permissionName}', '${url}')")
    public void save(Permission permission) throws Exception;

    /**
     * 查询单条权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id = #{id}")
    public Permission findById(Integer id) throws Exception;

    /**
     * 根据权限id删除权限和角色有关联的数据
     *
     * @param id
     * @throws Exception
     */
    @Delete("delete from role_permission where permissionId = #{id}")
    public void deleteFromRole_PermissionByPermissionId(Integer id) throws Exception;

    /**
     * 删除单条权限
     *
     * @param id
     * @throws Exception
     */
    @Delete("delete from permission where id = #{id}")
    public void deletePermissionById(Integer id) throws Exception;

}
