package com.sh303.ssm_pm.service.impl;

import com.github.pagehelper.PageHelper;
import com.sh303.ssm_pm.dao.IPermissionDao;
import com.sh303.ssm_pm.entity.Permission;
import com.sh303.ssm_pm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IPermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao iPermissionDao;

    /**
     * 分页查询所有权限
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> findAll(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        return iPermissionDao.findAll();
    }

    /**
     * 添加单条权限
     *
     * @param permission
     * @throws Exception
     */
    @Override
    public void save(Permission permission) throws Exception {
        iPermissionDao.save(permission);
    }

    @Override
    public Permission findById(Integer id) throws Exception {
        return iPermissionDao.findById(id);
    }

    /**
     * 删除单条权限
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void deletePermission(Integer id) throws Exception {
        // 先删除 权限和角色有关联的数据
        iPermissionDao.deleteFromRole_PermissionByPermissionId(id);
        // 后删除 权限
        iPermissionDao.deletePermissionById(id);
    }

}
