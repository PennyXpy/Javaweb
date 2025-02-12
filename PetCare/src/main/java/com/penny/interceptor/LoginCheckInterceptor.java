package com.penny.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.penny.pojo.Result;
import com.penny.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    // 目标资源方法运行前运行，返回True放行 返回False不放行
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {

        //获取请求url
        String url = req.getRequestURI().toString();
        log.info("url:{}", url);

        //url是不是有login 有就直接放行
        if (url.contains("login")) {
            log.info("login操作 直接放行");
            return true;
        }

        //获取请求头中的token
        String jwt = req.getHeader("token");
        //判断令牌是不是存在 不错在返回错误结果
        if (! StringUtils.hasLength(jwt)) {
            log.info("请求token是空");
            Result error = Result.error("Not Login");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
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
            return false;
        }

        //放行
        log.info("合法 放行");
        return true;
    }

    //目标资源方法运行后运行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    // 视图渲染后运行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
