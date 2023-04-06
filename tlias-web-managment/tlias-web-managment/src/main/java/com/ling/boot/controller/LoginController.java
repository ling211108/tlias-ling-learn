package com.ling.boot.controller;

import com.ling.boot.pojo.Emp;
import com.ling.boot.pojo.Result;
import com.ling.boot.service.EmpService;
import com.ling.boot.utils.JwtUtils;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录: {}",emp);
        Emp e = empService.login(emp);

        //登录成功，生成jwt令牌并返回客户端
        if(e != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("username",e.getUsername());
            claims.put("password",e.getPassword());
            String jwt = JwtUtils.generateJwt(claims);

            return Result.success(jwt);
        }

        //登录失败,返回失败信息
        return Result.error("你是傻子吗？这都记不住？");
    }

}
