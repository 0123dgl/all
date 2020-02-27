package com.ex.controller;

import com.ex.domain.User;
import com.ex.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MybatisContoller {
    @Autowired
    //这个地方报错, 因为还没有这个类, 编译后就有这个类了
    public UserMapper userMapper;

    @RequestMapping("/aaa")
    @ResponseBody
    public List<User> findAll() {
        List<User> users = userMapper.findAll();
        return users;
    }
}
