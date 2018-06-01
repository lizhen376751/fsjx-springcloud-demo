package com.fsjx.zullfilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * zull接口网关过滤器
 * Created by lizhen on 2018\5\30 0030.
 */
@Component
public class MyZullFilter extends ZuulFilter {
    private static final Logger log = LoggerFactory.getLogger(MyZullFilter.class);
    //pre：前置过滤器
    @Override
    public String filterType() {
        return "pre";
    }

    //filterOrder：过滤的顺序,过滤顺序，数字越大级别越低
    @Override
    public int filterOrder() {
        return 0;
    }

    //shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
    //这里必须写true，否则就会抛出异常
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.info("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                HttpServletResponse response = ctx.getResponse();
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("token 参数为空，无权访问！！！");
            }catch (Exception e){}

            return null;
        }

        log.info("ok");
        return null;

    }
}
