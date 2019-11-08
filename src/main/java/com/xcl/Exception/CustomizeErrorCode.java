package com.xcl.Exception;

public enum CustomizeErrorCode implements  ICustomizeErrorCode {
    QUESTION_NOT_FOUND("你查找的问题不存在或者已被删除，要不换一个试试？？") ;
    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
