package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    //@Autowired
    //dubbo的订阅注解，替代了上面的注入
    @Reference(loadbalance = "roundrobin")
    UserService userService;

    @RequestMapping("/findById")
    public User findById(Integer id) {
        User user = userService.findById(id);
        return user;
    }
}