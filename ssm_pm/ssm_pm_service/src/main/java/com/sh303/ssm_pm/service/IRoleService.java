package com.sh303.ssm_pm.service;

import com.sh303.ssm_pm.entity.Permission;
import com.sh303.ssm_pm.entity.Role;

import java.util.List;

public interface IRoleService {

    /**
     * 分页查询所有角色
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<Role> findAll(Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 添加单条角色
     *
     * @param role
     */
    public void save(Role role) throws Exception;

    /**
     * 查询单条角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Role findById(Integer id) throws Exception;

    /**
     * 删除角色
     *
     * @param roleId
     * @throws Exception
     */
    public void deleteRoleById(Integer roleId) throws Exception;

    /**
     * 查询角色未添加的权限
     *
     * @param roleId
     * @return
     */
    public List<Permission> findOtherPermission(Integer roleId) throws Exception;

}
