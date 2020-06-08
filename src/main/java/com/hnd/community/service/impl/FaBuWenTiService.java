package com.hnd.community.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnd.community.bean.ArticleAndcreatorModel;
import com.hnd.community.bean.ArticleModel;
import com.hnd.community.bean.UserModel;
import com.hnd.community.dao.ArticleMapper;
import com.hnd.community.dao.UserMapper;
import com.hnd.community.service.FaBuWenTiServiceIfac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FaBuWenTiService implements FaBuWenTiServiceIfac {
    @Autowired
    ArticleMapper dao;
    @Autowired
    UserMapper userDao;
    @Override
    public List<String> getHotTags() {
        List<String> hotTags = dao.selectHotTags();
        return hotTags;
    }

    /**
     * 插入文章内容以及tags
     * @param articleModel
     * @return
     */
    @Override
    public Integer addArticle(ArticleModel articleModel, UserModel model) {
        articleModel.setCreatorId(model.getId());//设置文章的作者ID
        articleModel.setArticleId(model.getId()+System.currentTimeMillis());//设置文章的id=作者id+创建的时间戳
        articleModel.setGmtCreat(System.currentTimeMillis());//设置文章创建的时间戳
        articleModel.setGmtModified(articleModel.getGmtCreat());//
        Integer result = dao.insertArticle(articleModel);
        Integer result2 = dao.insertTags(articleModel);
        System.out.println("result"+result+"========="+"result2"+result2);
        return result>0&&result2>0?result:0;
    }


    @Override
    public PageInfo getAllArticle(Integer  pn) {
        if(pn==null) pn = 1;
        PageHelper.startPage(pn,5);
        List<ArticleAndcreatorModel> list = dao.selectAll();
        PageInfo pages = new PageInfo(list,5);
        System.out.println(pages);
        return  pages;
    }

}
