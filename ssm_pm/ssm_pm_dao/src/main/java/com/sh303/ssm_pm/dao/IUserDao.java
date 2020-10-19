package com.sh303.ssm_pm.dao;

import com.sh303.ssm_pm.entity.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface IUserDao {

    /**
     * 根据用户 查询 用户和角色数据
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
            @Result(property = "roleList", column = "id", javaType = java.util.List.class, many = @Many(select = "com.sh303.ssm_pm.dao.IRoleDao.findByUid"))
    })
    public UserInfo findByUsername(String username) throws Exception;

}
