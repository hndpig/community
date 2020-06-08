package com.hnd.community.bean;

import lombok.Data;

import java.util.List;

@Data
public class ArticleAndcreatorModel {
    private  String articleId;
    private String creatorId;
    private String articleTitle;
    private String articleType;
    private String articleContent;
    private String articleContentText;
    private long gmtCreat;
    private long gmtModified;
    private long commentCount;
    private long viewCount;
    private long likeCount;
    private long dontLikeCount;
    private List<String> tags;
    private UserModel user;

}
