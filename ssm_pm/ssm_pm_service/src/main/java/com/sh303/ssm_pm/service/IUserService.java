package com.sh303.ssm_pm.service;

import com.sh303.ssm_pm.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    /**
     * 查询所有用户
     *
     * @return
     * @throws Exception
     */
    List<UserInfo> findAll(Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 添加用户
     *
     * @param userInfo
     * @throws Exception
     */
    void save(UserInfo userInfo) throws Exception;

    /**
     * 根据用户id查询用户详细
     *
     * @param uid
     * @return
     * @throws Exception
     */
    UserInfo findById(Integer uid) throws Exception;
}
