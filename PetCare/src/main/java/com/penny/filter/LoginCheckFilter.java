package com.penny.filter;


import com.alibaba.fastjson.JSONObject;
import com.penny.pojo.Result;
import com.penny.utils.JwtUtils;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //获取请求url
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String url = req.getRequestURI().toString();
        log.info("url:{}", url);

        //url是不是有login 有就直接放行
        if (url.contains("login")) {
            log.info("login操作 直接放行");
            chain.doFilter(request,response);
            return;
        }

        //获取请求头中的token
        String jwt = req.getHeader("token");
        //判断令牌是不是存在 不错在返回错误结果
        if (! StringUtils.hasLength(jwt)) {
            log.info("请求token是空");
            Result error = Result.error("Not Login");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        //解析token
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败返回未登录错误信息");
            Result error = Result.error("Not Login");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        //方形
        log.info("合法 放行");
        chain.doFilter(request,response);


    }
}

