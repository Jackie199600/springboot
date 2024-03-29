package com.xcl.dto;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: Jackie  Chan
 * Date: 2019/11/18
 * Time: 17:24
 */
@Data
public class QuestionQueryDTO {
    private String search;
    private String sort;
    private Long time;
    private String tag;
    private Integer page;
    private Integer size;
}
