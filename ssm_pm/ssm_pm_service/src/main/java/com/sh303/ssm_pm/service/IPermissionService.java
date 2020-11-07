package com.sh303.ssm_pm.service;

import com.sh303.ssm_pm.entity.Permission;

import java.util.List;

public interface IPermissionService {

    /**
     * 分页查询所有权限
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<Permission> findAll(Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 添加单条权限
     *
     * @param permission
     * @throws Exception
     */
    public void save(Permission permission) throws Exception;

    /**
     * 查询单条权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Permission findById(Integer id) throws Exception;

    /**
     * 删除单条权限
     *
     * @param id
     * @throws Exception
     */
    public void deletePermission(Integer id) throws Exception;
}
