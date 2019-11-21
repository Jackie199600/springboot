package com.xcl.cache;

import com.xcl.dto.HotTagDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jackie  Chan
 * Date: 2019/11/20
 * Time: 18:07
 */
@Component
@Data
public class HotTagCache {
    private List<String> hots = new ArrayList<>();

    /**
     * 根据权重进行排序
     *
     * @param tags
     */
    public void updateTags(Map<String, Integer> tags) {
        int max = 10;
        //PriorityQueue  基于Java的优先队列
        PriorityQueue<HotTagDTO> priorityQueue = new PriorityQueue<>(max);


        tags.forEach((name, priority) -> {
            HotTagDTO hotTagDTO = new HotTagDTO();
            hotTagDTO.setName(name);
            hotTagDTO.setPriority(priority);
            if (priorityQueue.size() < max) {
                priorityQueue.add(hotTagDTO);
            } else {
                //获取最小元素
                HotTagDTO minHot = priorityQueue.peek();
                if (hotTagDTO.compareTo(minHot) > 0) {
                    priorityQueue.poll();
                    priorityQueue.add(hotTagDTO);
                }
            }
        });

        List<String> sortedTags = new ArrayList<>();
        HotTagDTO poll = priorityQueue.poll();
        while (poll != null) {
            sortedTags.add(0, poll.getName());
            poll = priorityQueue.poll();

        }
        hots = sortedTags;
    }
}
