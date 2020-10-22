package com.sh303.ssm_pm.dao;

import com.sh303.ssm_pm.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {

    /**
     * 根据用户 查询 用户和角色数据
     *
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roleList", column = "id", javaType = java.util.List.class, many = @Many(select = "com.sh303.ssm_pm.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username) throws Exception;

    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from users")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roleList", column = "id", javaType = java.util.List.class, many = @Many(select = "com.sh303.ssm_pm.dao.IRoleDao.findRoleByUserId"))
    })
    public List<UserInfo> findAll() throws Exception;

    /**
     * 添加用户
     *
     * @param userInfo
     * @throws Exception
     */
    @Insert("insert into users(email, username, password, phoneNum, status) values(#{email}, #{username}, #{password}, #{phoneNum}, #{status})")
    public void save(UserInfo userInfo) throws Exception;

    /**
     * 根据用户id查询用户详细
     *
     * @param uid
     * @return
     * @throws Exception
     */
    @Select("select * from users where id = #{uid}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roleList", column = "id", javaType = java.util.List.class, many = @Many(select = "com.sh303.ssm_pm.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findById(Integer uid) throws Exception;

    /**
     * 根据角色id查询所有对应的用户
     *
     * @param rid
     * @return
     * @throws Exception
     */
    @Select("select * from users where id in (select usersId from users_role where roleId = #{rid})")
    public List<UserInfo> findUserByRoleId(Integer rid) throws Exception;
}
