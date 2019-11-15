package com.xcl.service;

import com.xcl.dto.NotificationDTO;
import com.xcl.dto.PaginationDTO;
import com.xcl.mapper.NotificationMapper;
import com.xcl.mapper.UserMapper;
import com.xcl.model.Notification;
import com.xcl.model.NotificationExample;
import com.xcl.model.User;
import com.xcl.model.UserExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NotificationService {
    @Autowired
    private NotificationMapper notificationMapper;
    @Autowired
    private UserMapper userMapper;

    public PaginationDTO list(Long userId, Integer page, Integer size) {
        PaginationDTO<NotificationDTO> paginationDTO = new PaginationDTO<>();
        Integer totalPage;
        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria().andReceiverEqualTo(userId);
        Integer totalCount = (int) notificationMapper.countByExample(notificationExample);
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        paginationDTO.setPagination(totalPage, page);
        //size*(page-1)
        Integer offset = size * (page - 1);
        if (offset < 0) {
            offset = 0;
        }
        NotificationExample example = new NotificationExample();
        example.createCriteria().andReceiverEqualTo(userId);
        List<Notification> notifications = notificationMapper.selectByExampleWithRowbounds(example, new RowBounds(offset, size));
        if (notifications.size() == 0) {
            return paginationDTO;
        }
        Set<Long> disUserId = notifications.stream().map(notify -> notify.getNotifier()).collect(Collectors.toSet());
        List<Long> userIds = new ArrayList<>(disUserId);

        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdIn(userIds);
        List<User> users = userMapper.selectByExample(userExample);

        Map<Long, User> userMap = users.stream().collect(Collectors.toMap(u -> u.getId(), u -> u));


        List<NotificationDTO> notificationDTOS = new ArrayList<>();
        paginationDTO.setData(notificationDTOS);
        return paginationDTO;
    }
}
