package com.xcl.dto;

import com.xcl.model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    //浏览数
    private Integer viewCount;
    //访问量
    private Integer commentCount;
    //点赞数
    private Integer likeCount;
    private User user;
}
