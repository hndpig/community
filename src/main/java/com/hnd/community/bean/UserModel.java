package com.hnd.community.bean;

import lombok.Data;
@Data
public class UserModel {
    String id ;
    String login;
    String token;
    Long gmt_createTime;
    Long gmt_modity;
    String avatarUrl;
    String bio;
}
