package com.itheima.health.service;

import com.itheima.health.entity.PageResult;
import com.itheima.health.pojo.Setmeal;

import java.util.List;

public interface SetmealService {

    void add(Setmeal setmeal, Integer[] checkgroupIds);

    PageResult findPage(Integer currentPage, Integer pageSize, String queryString);

    Setmeal findById(Integer id);

    List<Integer> findCheckGroupIdsBySetmealId(Integer id);

    void edit(Setmeal setmeal, Integer[] checkgroupIds);

    void delete(Integer id);

    List<Setmeal> findAll();
}
