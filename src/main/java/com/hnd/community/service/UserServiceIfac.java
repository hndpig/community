package com.hnd.community.service;

import com.hnd.community.bean.UserModel;

public interface UserServiceIfac {
    UserModel findUserByToken(String token);
    int userLogin(UserModel user);
    int modifyUser(UserModel userModel);
    UserModel findUserById(String id);
}
