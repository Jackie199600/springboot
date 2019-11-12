package com.xcl.Exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001, "你查找的问题不存在或者已被删除，要不换一个试试？？"),
    TARGET_PARAM_NOT_FOUND(2002, "未选择要回复的问题或评论"),
    NO_LOGIN(2003, "未登录不能进行评论，请先登录"),
    SYS_ERROR(2004, "服务冒烟了，要不你稍后再试试？？"),
    TYPE_PARAM_WRONG(2005, "评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006, "你操作的评论不存在或者已被删除，要不换一个试试？"),
    CONTENT_IS_EMPTY(2007, "回复内容不能为空！");


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }


}
