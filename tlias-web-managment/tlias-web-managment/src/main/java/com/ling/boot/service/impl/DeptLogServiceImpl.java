package com.ling.boot.service.impl;


import com.ling.boot.mapper.DeptLogMapper;
import com.ling.boot.pojo.DeptLog;
import com.ling.boot.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptLogServiceImpl implements DeptLogService {

    @Autowired
    private DeptLogMapper deptLogMapper;
    /*propagation 设置事务的传播行为，默认REQUIRES传播行为
    * REQUIRES_NEW 此传播行为不管是否嵌套到了其他事务都会创建一个新事务*/
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(DeptLog deptLog) {
        deptLogMapper.insert(deptLog);
    }
}
