package com.itheima.filter;

import com.itheima.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取请求路径
        String path = request.getRequestURI();

        //判断是否是登录请求，如果包含 /login, 放行
        if (path.contains("/login")) {
            log.info("登录请求，放行");
            filterChain.doFilter(request, response);
            return;
        }

        //获取请求头中的令牌
        String token = request.getHeader("token");

        //判断token是否存在
        if (token == null || token.isEmpty()) {
            log.info("令牌为空，请求被拦截");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        //教研token令牌
        try {
            //解析token
            JwtUtils.parseJWT(token);

        } catch (Exception e) {
            log.info("令牌解析失败，请求被拦截");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        log.info("令牌解析成功，放行");
        filterChain.doFilter(request, response);
    }
}
