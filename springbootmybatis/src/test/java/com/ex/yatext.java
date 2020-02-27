package com.ex;


import com.ex.domain.User;
import com.ex.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootmybatisApplication.class)
public class yatext {
    @Autowired
    UserMapper userMapper;
    @Test
    public void fun() {
        List<User> users = userMapper.findAll();
        System.out.println(users);
    }
}
