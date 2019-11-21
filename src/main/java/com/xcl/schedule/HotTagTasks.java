package com.xcl.schedule;

import com.xcl.cache.HotTagCache;
import com.xcl.mapper.QuestionMapper;
import com.xcl.model.Question;
import com.xcl.model.QuestionExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jackie  Chan
 * Date: 2019/11/20
 * Time: 17:06
 */
@Component
@Slf4j
public class HotTagTasks {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private HotTagCache hotTagCache;

    /**
     * Spring boot 的定时器  定时更新数据
     */

    @Scheduled(fixedRate = 1000 * 60 * 60 * 3)//每三小时更新一次
    public void reportCurrentTime() {
        int offset = 0;
        int limit = 5;
        List<Question> list = new ArrayList<>();

        Map<String, Integer> priorities = new HashMap<>();
        while (offset == 0 || list.size() == limit) {
            list = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds(offset, limit));
            for (Question question : list) {

                String[] tags = StringUtils.split(question.getTag(), ",");

                for (String tag : tags) {
                    Integer priority = priorities.get(tag);
                    if (priority != null) {
                        priorities.put(tag, priority + 5 + question.getCommentCount()); //计算权重
                    } else {
                        priorities.put(tag, 5 + question.getCommentCount());
                    }
                }

            }
            offset += limit;
        }
        hotTagCache.updateTags(priorities);
    }
}
