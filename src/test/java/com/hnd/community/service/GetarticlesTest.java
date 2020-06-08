package com.hnd.community.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnd.community.bean.ArticleAndcreatorModel;
import com.hnd.community.bean.ArticleModel;
import com.hnd.community.dao.ArticleMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class GetarticlesTest {
    @Autowired
    FaBuWenTiServiceIfac service;
    @Autowired
    ArticleMapper dao;
    @Test
    void getAll() {
        PageInfo allArticle = service.getAllArticle(1);
        System.out.println(allArticle);

    }
}