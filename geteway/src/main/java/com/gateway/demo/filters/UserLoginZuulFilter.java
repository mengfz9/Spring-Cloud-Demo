package com.gateway.demo.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component //加入到Spring容器
public class UserLoginZuulFilter extends ZuulFilter {

    //具体的业务逻辑
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        log.info("Method:{} URI:{}",request.getMethod(),request.getRequestURI());
        Object token = request.getParameter("loginToken");
        if (token == null){
            log.info("loginToken is null");
            requestContext.setSendZuulResponse(false); //过滤掉该请求，不对其进行路由转发
            requestContext.setResponseStatusCode(401); //设置返回的错误码x
        }else {
            log.info("loginToken is not null");
        }
        return null;
    }

    // 该过滤器是否需要执行
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器类型
     *  pre：请求前执行
     *  Routing：路由过滤器
     *  Post：在Response 相应之前执行过滤
     * @return
     */
    @Override
    public String filterType() {
        return "pre"; // 设置过滤器类型为：pre
    }

    // 设置执行顺序 越小越先执行
    @Override
    public int filterOrder() {
        return 0;
    }

}
