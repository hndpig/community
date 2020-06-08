package com.hnd.community.bean;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;

@Data
public class ArticleModel {
    private  String articleId;
    private String creatorId;
    @Pattern(regexp = "(^(?=.*\\S).+$)",message = "标题不能为空")
    @NotEmpty(message = "标题不能为空" )
    private String articleTitie;
    @NotEmpty(message = "类别必选")
    private String articleType;
    //@Pattern(regexp = "(^(<p>)\\s*$)",message = "内容不能为空")
    private String articleContent;
    @Pattern(regexp = "(^(?=.*\\S).+$)",message = "内容不能为空")
    private String articleContentText;
    private long gmtCreat;
    private long gmtModified;
    private long commentCount;
    private long viewCount;
    private long likeCount;
    private long dontLikeCount;
    @Size(min = 1,message = "至少一个标签")
    private List<String> tags;
}
