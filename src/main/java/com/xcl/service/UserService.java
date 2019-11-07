package com.xcl.service;

import com.xcl.mapper.UserMapper;
import com.xcl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
      User dbUser = userMapper.findByAccountId(user.getAccountId());
      if (dbUser==null){
          //当用户不存在时  创建用户
          user.setGmtCreate(System.currentTimeMillis());
          user.setGmtModified(user.getGmtCreate());
          userMapper.insert(user);
      }else {
          //当用户存在时 更新token值
          dbUser.setGmtModified(System.currentTimeMillis());
          dbUser.setAvatarUrl(user.getAvatarUrl());
          dbUser.setName(user.getName());
          dbUser.setToken(user.getToken());
          userMapper.update(dbUser  );
      }
    }


}
