package com.xuz.service;

import com.xuz.common.vo.JSONObject;
import com.xuz.pojo.User;

public interface UserService {
    JSONObject queryUser(User user);
}
