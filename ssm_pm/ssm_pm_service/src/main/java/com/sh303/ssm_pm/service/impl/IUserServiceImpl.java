package com.sh303.ssm_pm.service.impl;

import com.github.pagehelper.PageHelper;
import com.sh303.ssm_pm.dao.IUserDao;
import com.sh303.ssm_pm.entity.Role;
import com.sh303.ssm_pm.entity.UserInfo;
import com.sh303.ssm_pm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = iUserDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 处理自己的用户对象封装成 UserDetails    user是springSecurity中 实现 UserDetails 的类
        // User user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(), getAuthority(userInfo.getRoleList()));
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoleList()));
        return user;
    }

    /**
     * 作用就是返回一个List 集合，集合中装入的是角色描述
     *
     * @param roles
     * @return
     */
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName().toUpperCase()));
        }
        return list;
    }

    /**
     * 查询所有用户
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<UserInfo> findAll(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        return iUserDao.findAll();
    }

    /**
     * 添加用户
     *
     * @param userInfo
     * @throws Exception
     */
    @Override
    public void save(UserInfo userInfo) throws Exception {
        // 对密码进行加密处理
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        iUserDao.save(userInfo);
    }

    /**
     * 根据用户id查询用户详细
     *
     * @param uid
     * @return
     * @throws Exception
     */
    @Override
    public UserInfo findById(Integer uid) throws Exception {
        return iUserDao.findById(uid);
    }
}
