package com.hnd.community.service;

import com.hnd.community.bean.ArticleModel;
import com.hnd.community.dao.ArticleMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class FaBuWenTiServiceTest {
@Autowired
ArticleMapper dao;
    @Test
    void addTags() {
        ArticleModel model =new ArticleModel();
        model.setArticleId("123456");
        model.setCreatorId("1564");
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("c");
        list.add("c++");
        list.add("c");
        list.add("c");
        list.add("c");

        model.setTags(list);


        dao.insertArticle(model);
    }
}