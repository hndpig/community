package com.hnd.community.service;

import com.github.pagehelper.PageInfo;
import com.hnd.community.bean.ArticleAndcreatorModel;
import com.hnd.community.bean.ArticleModel;
import com.hnd.community.bean.UserModel;

import java.util.List;
import java.util.Map;

public interface FaBuWenTiServiceIfac {
    List<String> getHotTags();
    Integer addArticle(ArticleModel articleModel, UserModel model);
    PageInfo getAllArticle(Integer pn);
}
