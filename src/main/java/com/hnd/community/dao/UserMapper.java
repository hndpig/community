package com.hnd.community.dao;

import com.hnd.community.bean.UserModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserModel selectUserByToken(String token);

    int insertUser(UserModel user);

    int upDateUser(UserModel userModel);

    UserModel selectUserById(String id);
}
