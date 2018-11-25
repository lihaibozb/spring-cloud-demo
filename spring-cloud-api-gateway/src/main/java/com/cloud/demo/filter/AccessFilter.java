package com.cloud.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lihaibo
 * @version v1.0.0
 * @date 2018/11/8 8:46 PM
 * @description 资源过滤器
 * 所有的资源请求在路由之前进行前置过滤
 * 如果请求头不包含 Authorization参数值，直接拦截不再路由
 */
public class AccessFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        Object accessToken = request.getHeader("Authorization");
        if (accessToken == null) {
            //支持API查看
            if (!request.getRequestURI().contains("/api-docs")) {
                logger.warn("Authorization token is empty");
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(401);
                requestContext.setResponseBody("Authorization token is empty");
                return null;
            }
        }
        logger.info("Authorization token is ok");

        return null;
    }

}
