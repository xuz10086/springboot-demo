package com.xuz.controller;

import com.xuz.common.vo.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xuz.pojo.User;
import com.xuz.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @RequestMapping("/query")
    public JSONObject queryUser(User user) {

        JSONObject jsonObject = userService.queryUser(user);
        return jsonObject;
    }
}
