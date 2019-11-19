package com.xcl.mapper;

import com.xcl.dto.QuestionQueryDTO;
import com.xcl.model.Question;

import java.util.List;

public interface QuestionExtMapper {

    int incView(Question record);

    int inCommentCount(Question record);

    List<Question> selectRelated(Question question);

    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}