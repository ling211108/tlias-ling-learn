package com.ling.boot.service;

import com.ling.boot.pojo.Dept;

import java.util.List;

public interface DeptService {
    /*查询部门*/
    List<Dept> list();
    /*删除部门*/
    void delete(Integer id) throws Exception;
    /*新增部门*/
    void add(Dept dept);

    /*根据id查询到指定部门*/
    Dept getById(Integer id);

    void update(Dept dept);
}
