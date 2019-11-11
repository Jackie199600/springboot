package com.xcl.mapper;

import com.xcl.model.Question;

public interface QuestionExtMapper {

    int incView(Question record);

    int inCommentCount(Question record);
}