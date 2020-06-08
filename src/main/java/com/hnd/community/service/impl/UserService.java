package com.hnd.community.service.impl;


import com.hnd.community.bean.UserModel;
import com.hnd.community.dao.UserMapper;
import com.hnd.community.service.UserServiceIfac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceIfac {
    @Autowired
    UserMapper dao;

    @Override
    public UserModel findUserByToken(String token) {
       return  dao.selectUserByToken(token);
    }

    @Override
    public int userLogin(UserModel user) {
        Integer integer;
        UserModel userModel = this.findUserById(user.getId());
        if(userModel!=null){
           integer = this.modifyUser(user);
        }else{
            integer = dao.insertUser(user);
        }
        return integer;
    }

    @Override
    public int modifyUser(UserModel userModel) {
        int num = dao.upDateUser(userModel);
        return num;
    }

    @Override
    public UserModel findUserById(String id) {
        UserModel user = dao.selectUserById(id);
        return user;
    }
}
