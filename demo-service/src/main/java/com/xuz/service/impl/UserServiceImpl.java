package com.xuz.service.impl;

import com.xuz.common.vo.JSONObject;
import com.xuz.mapper.UserMapper;
import com.xuz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import com.xuz.pojo.User;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public JSONObject queryUser(User user) {
        String key = "user_" + user.getLUserId();
        ValueOperations operations = redisTemplate.opsForValue();
        Boolean hasKey = redisTemplate.hasKey(key);

        // 缓存中存在，则从缓存内拿取
        if (hasKey) {
            List<User> redisUser = (List<User>) operations.get(key);
            System.out.println("从缓存中拿到用户：" + redisUser);
            return JSONObject.build(200, "缓存查询", redisUser);
        }
        List<User> userList = userMapper.queryUserList(user);

        // 插入缓存
        operations.set(key, userList, 10, TimeUnit.HOURS);
        System.out.println("用户插入缓存");
        return JSONObject.build(200, "查询成功", userList);
    }
}
