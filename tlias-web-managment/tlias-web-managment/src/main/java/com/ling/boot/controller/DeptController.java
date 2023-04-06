package com.ling.boot.controller;

import com.ling.boot.anno.Log;
import com.ling.boot.pojo.Dept;
import com.ling.boot.pojo.Result;
import com.ling.boot.service.DeptService;
import com.ling.boot.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    //private static Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;

    /**
     * 查询部门
     */
    //@RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping()
    public Result list(){
        log.info("查询全部部门数据");
        //调用service查询部门数据
        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }


    /**
     * 删除部门
     */
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id) throws Exception {
        log.info("根据id删除部门:{}",id);
        //调用service删除部门
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门
     */
    @Log
    @PostMapping()
    public Result add(@RequestBody Dept dept){
        log.info("新增部门: {}",dept);
        //调用service
        deptService.add(dept);
        return Result.success();
    }
    //获取部门

    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Integer id){
        log.info("查询部门: {}",id);
        //调service
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    //修改部门
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门: {}",dept);
        //调用service
        deptService.update(dept);
        return Result.success();
    }




}
