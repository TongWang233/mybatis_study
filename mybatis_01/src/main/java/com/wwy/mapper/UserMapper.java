package com.wwy.mapper;

import com.wwy.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    //根据id查询用户信息
    @Select( "select * from USER")
    public List<User> findAllUser();

    @Select("select * from user where id = #{id}")
    User selectUserById(@Param("id") int id);

    //添加一个用户
    @Insert("insert into user (id,username,sex,address) values (#{id},#{username},#{sex},#{address})")
    int addUser(User user);
}
