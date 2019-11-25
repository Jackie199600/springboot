package com.xcl.dto;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: Jackie  Chan
 * Date: 2019/11/25
 * Time: 14:10
 */
@Data
public class UserLike {
    //主键ID

    private Integer id;
    //被点赞用户ID
    private String likedUserId;
    //点赞用户ID
    private String likedPostId;
    //点赞的状态
    private Integer status;

    public UserLike() {
    }

    public UserLike(Integer id, String likedUserId, String likedPostId, Integer status) {
        this.id = id;
        this.likedUserId = likedUserId;
        this.likedPostId = likedPostId;
        this.status = status;
    }
}
