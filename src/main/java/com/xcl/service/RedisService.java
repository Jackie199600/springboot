package com.xcl.service;

import com.xcl.dto.LikeCountDTO;
import com.xcl.dto.UserLike;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RedisService {
    /**
     * 点赞   状态为1
     *
     * @param likedUserId
     * @param likedPostId
     */
    void likeFromRedis(String likedUserId, String likedPostId);

    /**
     * 取消点赞  状态为0
     *
     * @param likeUserId
     * @param likePostId
     */
    void unLikeFromRedis(String likeUserId, String likePostId);

    /**
     * 删除一条点赞数据
     *
     * @param likeUserId
     * @param likePostId
     */
    void deleteLikeFromRedis(String likeUserId, String likePostId);


    /**
     * 点赞数  加1
     *
     * @param likeUserId
     */
    void addLikeFromRedis(String likeUserId);


    /**
     * 点赞数  减1
     *
     * @param likeUserId
     */
    void subLikeFromRedis(String likeUserId);

    /**
     * 获取Redis中的点赞数据
     *
     * @return
     */
    List<UserLike> getLikeDataFromRedis();

    /**
     * 获取Redis中存储的点赞数量
     *
     * @return
     */
    List<LikeCountDTO> getLikeCountFromRedis();
}
