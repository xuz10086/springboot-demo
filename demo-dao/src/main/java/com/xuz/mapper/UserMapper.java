package com.xuz.mapper;


import com.xuz.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> queryUserList(User user);
}
