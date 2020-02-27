package com.itheima.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author ly
 * @Company 深圳黑马程序员
 * @Date 2020/2/25 11:35
 * @Version V1.0
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    // 新增
    @RequestMapping(value = "/add")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public String add(){
        System.out.println("add...");
        return "add";
    }
    // 删除
    @RequestMapping(value = "/delete")
    @PreAuthorize(value = "hasAuthority('delete')")
    public String delete(){
        System.out.println("delete...");
        return "delete";
    }
    // 修改
    // 如果没有权限：org.springframework.security.access.AccessDeniedException: Access is denied
    @RequestMapping(value = "/update")
    @PreAuthorize(value = "hasAuthority('update')")
    public String update(){
        System.out.println("update...");
        return "update";
    }
}
