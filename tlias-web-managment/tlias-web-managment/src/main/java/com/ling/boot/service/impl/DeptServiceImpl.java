package com.ling.boot.service.impl;

import com.ling.boot.mapper.DeptLogMapper;
import com.ling.boot.mapper.DeptMapper;
import com.ling.boot.mapper.EmpMapper;
import com.ling.boot.pojo.Dept;
import com.ling.boot.pojo.DeptLog;
import com.ling.boot.service.DeptLogService;
import com.ling.boot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptLogService deptLogService;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }
    /*rollbackFor 为开启事务的范围 Exception.class 为全异常范围内都开启事务 */
    @Transactional(rollbackFor = Exception.class) //在此方法中开启有spring提供事务管理
    @Override
    public void delete(Integer id) throws Exception {

        try {
            deptMapper.deleteById(id); //根据id删除部门

            //int i = 1 / 0; //模拟异常
//            if (true) {
//                throw new Exception("出错了...");
//            }
            empMapper.deleteByDeptId(id); //根据部门id删除员工

        } finally {
            //记录解散部门日志
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，此次解散的是"+id+"号部门");
            deptLogService.insert(deptLog);
        }
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        Dept dept = deptMapper.getById(id);
        return dept;
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }


}
