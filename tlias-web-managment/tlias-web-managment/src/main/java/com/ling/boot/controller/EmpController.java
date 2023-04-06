package com.ling.boot.controller;

import com.ling.boot.anno.Log;
import com.ling.boot.pojo.Emp;
import com.ling.boot.pojo.PageBean;
import com.ling.boot.pojo.Result;
import com.ling.boot.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "1") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate end
                       ){
        log.info("分页查询,参数:{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        //调用service分页查询
        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);
        return  Result.success(pageBean);
    }
    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除操作,ids:{}",ids);
        empService.delete(ids);
        return Result.success();
    }
    @Log
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工，emp:{}",emp);
        empService.save(emp);
        return Result.success();
    }

    //查询回显员工
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Integer id){
        log.info("根据id查询员工信息,id: {}",id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }
    @Log
    //修改员工
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工信息: {}",emp);
        empService.update(emp);
        return Result.success();
    }

}
