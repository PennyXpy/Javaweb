package com.penny.controller;

import com.penny.pojo.Emp;
import com.penny.pojo.Result;
import com.penny.service.EmpService;
import com.penny.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class loginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("员工登陆：{}", emp);
        Emp e = empService.login(emp);
        // 登录成功 -- 生成令牌 发放令牌
        if (e != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
            claims.put("name", e.getName());
            String jwt = JwtUtils.generateJwt(claims); // JWT包含当前登录的员工信息
            return Result.success(jwt);
        }

        //失败 返回错误信息
        return Result.error("用户名或密码错误");
    }
}
