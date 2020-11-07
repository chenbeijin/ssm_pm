package com.sh303.ssm_pm.service.impl;

import com.github.pagehelper.PageHelper;
import com.sh303.ssm_pm.dao.IRoleDao;
import com.sh303.ssm_pm.entity.Permission;
import com.sh303.ssm_pm.entity.Role;
import com.sh303.ssm_pm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IRoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao iRoleDao;

    /**
     * 分页查询所有角色
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findAll(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        return iRoleDao.findAll();
    }

    /**
     * 添加单条角色
     *
     * @param role
     */
    @Override
    public void save(Role role) throws Exception {
        iRoleDao.save(role);
    }

    /**
     * 查询单条角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Role findById(Integer id) throws Exception {
        return iRoleDao.findById(id);
    }

    /**
     * 删除角色
     *
     * @param roleId
     * @throws Exception
     */
    @Override
    public void deleteRoleById(Integer roleId) throws Exception {
        // 先删除 角色和用户的中间表有关联的数据
        iRoleDao.deleteFromUser_RoleByRoleId(roleId);
        // 再删除 角色和权限的中间表有关联的数据
        iRoleDao.deleteFromRole_PermissionByRoleId(roleId);
        // 再删除 角色
        iRoleDao.deleteRoleById(roleId);
    }

    /**
     * 查询角色未添加的权限
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> findOtherPermission(Integer roleId) throws Exception {
        return iRoleDao.findOtherPermission(roleId);
    }
}
