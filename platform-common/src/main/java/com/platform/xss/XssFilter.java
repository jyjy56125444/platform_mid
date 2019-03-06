package com.platform.xss;

import jline.internal.Log;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * XSS过滤
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-04-01 10:20
 */
public class XssFilter implements Filter {
    //需要排除过滤的url
    private String excludedPages;
    private String[] excludedPageArray;

    @Override
    public void init(FilterConfig config) throws ServletException {
        excludedPages = config.getInitParameter("excludedPages");
        if (StringUtils.isNotEmpty(excludedPages)) {
            excludedPageArray = excludedPages.split(",");
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest) request);
//
//        boolean isExcludedPage = false;
//        for (String page : excludedPageArray) {
//            //判断是否在过滤url之外
//            if (((HttpServletRequest) request).getServletPath().equals(page)) {
//                isExcludedPage = true;
//                break;
//            }
//        }
//        if (isExcludedPage) {
//            //排除过滤url
//            chain.doFilter(request, response);
//        } else {
//            chain.doFilter(xssRequest, response);
//        }

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String type = req.getMethod();

        String[] allowDomains = {"http://127.0.0.1:8020", "http://localhost:8020", "http://127.0.0.1:8080", "http://localhost:8080", "http://127.0.0.1:80", "http://localhost:80"};
        Set allowOrigins = new HashSet(Arrays.asList(allowDomains));
        String originHeads = req.getHeader("Origin");
        if(allowOrigins.contains(originHeads)){
            //设置允许跨域的配置
            // 这里填写你允许进行跨域的主机ip（正式上线时可以动态配置具体允许的域名和IP）
            res.setHeader("Access-Control-Allow-Origin", originHeads);
        }
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT, OPTIONS");
        res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        chain.doFilter(request, res);

    }

    @Override
    public void destroy() {
    }
}