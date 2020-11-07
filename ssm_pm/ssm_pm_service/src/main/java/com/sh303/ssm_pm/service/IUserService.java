package com.sh303.ssm_pm.service;

import com.sh303.ssm_pm.entity.Role;
import com.sh303.ssm_pm.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    /**
     * 分页查询所有用户
     *
     * @return
     * @throws Exception
     */
    public List<UserInfo> findAll(Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 添加用户
     *
     * @param userInfo
     * @throws Exception
     */
    public void save(UserInfo userInfo) throws Exception;

    /**
     * 根据用户id查询用户详细
     *
     * @param uid
     * @return
     * @throws Exception
     */
    public UserInfo findById(Integer uid) throws Exception;

    /**
     * 用户添加角色
     *
     * @param userId
     * @param ids
     * @throws Exception
     */
    public void addRoleToUser(Integer userId, Integer[] ids) throws Exception;

    /**
     * 删除单条用户
     *
     * @param id
     * @throws Exception
     */
    public void deleteUserById(Integer id) throws Exception;

    /**
     * 查询用户未添加的角色
     *
     * @param userId
     * @return
     */
    public List<Role> findOtherRoles(Integer userId) throws Exception;
}
