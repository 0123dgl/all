package com.itheima.job;

import java.util.Date;

/**
 * 自定义Job
 */
public class JobDemo {
    public void run() {
        System.out.println("job execute...,执行时间：" + new Date());
    }
}