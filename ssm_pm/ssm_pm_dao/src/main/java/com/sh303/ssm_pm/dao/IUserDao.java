package com.sh303.ssm_pm.dao;

import com.sh303.ssm_pm.entity.Role;
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

    /**
     * 用户添加角色
     *
     * @param usersId
     * @param roleId
     * @throws Exception
     */
    @Insert("insert into users_role(usersId, roleId) values(#{usersId}, #{roleId})")
    public void addRoleToUser(@Param("usersId") Integer usersId, @Param("roleId") Integer roleId) throws Exception;

    /**
     * 根据用户id删除用户和角色中间表有联系的数据
     *
     * @param id
     * @throws Exception
     */
    @Delete("delete from users_role where usersId = #{id}")
    public void deleteFromUser_RoleByUserId(Integer id) throws Exception;

    /**
     * 根据用户id删除用户
     *
     * @param id
     * @throws Exception
     */
    @Delete("delete from users where id = #{id}")
    public void deleteUserById(Integer id) throws Exception;

    /**
     * 查询用户未添加的角色
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id not in (select roleId from users_role where usersId = #{userId})")
    public List<Role> findOtherRoles(Integer userId) throws Exception;
}
