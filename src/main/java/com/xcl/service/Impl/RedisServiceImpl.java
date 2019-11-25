package com.xcl.service.Impl;

import com.xcl.dto.LikeCountDTO;
import com.xcl.dto.UserLike;
import com.xcl.service.RedisService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jackie  Chan
 * Date: 2019/11/25
 * Time: 16:18
 */
public class RedisServiceImpl implements RedisService {
    @Override
    public void likeFromRedis(String likedUserId, String likedPostId) {

    }

    @Override
    public void unLikeFromRedis(String likeUserId, String likePostId) {

    }

    @Override
    public void deleteLikeFromRedis(String likeUserId, String likePostId) {

    }

    @Override
    public void addLikeFromRedis(String likeUserId) {

    }

    @Override
    public void subLikeFromRedis(String likeUserId) {

    }

    @Override
    public List<UserLike> getLikeDataFromRedis() {
        return null;
    }

    @Override
    public List<LikeCountDTO> getLikeCountFromRedis() {
        return null;
    }
}
