package com.train.portal.biz;

import com.train.security.entity.SysMenu;
import com.train.security.entity.SysRole;
import com.train.security.entity.SysUser;
import com.train.security.service.ISysMenuService;
import com.train.security.service.ISysRoleService;
import com.train.security.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class IPortalBizImpl implements IPortalBiz {
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysRoleService sysRoleService;
    @Autowired
    private ISysMenuService sysMenuService;

    @Override
    public SysUser findUserByUserCode(String userCode) {
        return sysUserService.findUserByUserCode(userCode);
    }

    @Override
    public SysUser findUserById(Integer uuId) {
        return sysUserService.findUserById(uuId);
    }

    @Override
    public SysUser findUserByUserCodeOrNickName(String userCodeOrNickName) {
        return sysUserService.findUserByUserCodeOrNickName(userCodeOrNickName);
    }

    @Override
    public Collection<SysRole> findRolesByUserCode(String userCode) {
        return sysRoleService.findAllRoleByUserUUID(sysUserService
                .findUserByUserCode(userCode).getUuId());
    }

    @Override
    public void updateUserPwd(Integer uuId, String userNewPwd) {
        sysUserService.updateUserPwd(uuId, userNewPwd);
    }

    @Override
    public Collection<SysMenu> findAllChildMenus(Long menuParentId,
                                                 String menuIds) {
        return sysMenuService.findAllChildMenus(menuParentId, menuIds);
    }

    @Override
    public Collection<SysMenu> findMenusByListId(String menuIds) {
        return sysMenuService.findMenusByListId(menuIds);
    }

}
