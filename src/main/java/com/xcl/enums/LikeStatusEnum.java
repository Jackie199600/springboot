package com.xcl.enums;

import lombok.Getter;

/**
 * 点赞用户的状态
 */

@Getter
public enum LikeStatusEnum {
    LIKE(1, "点赞"),
    UNLIKE(0, "未点赞/取消点赞"),
    ;
    private Integer code;
    private String msg;

    LikeStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
