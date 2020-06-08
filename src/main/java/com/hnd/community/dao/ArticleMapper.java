package com.hnd.community.dao;

import com.hnd.community.bean.ArticleAndcreatorModel;
import com.hnd.community.bean.ArticleModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleMapper {
    List<ArticleAndcreatorModel> selectAll();
    List<String> selectHotTags();
    Integer insertArticle(ArticleModel articleModel);
    Integer insertTags(ArticleModel articleModel);
    List<String> selectTagByArticleId(String articleId);
}
