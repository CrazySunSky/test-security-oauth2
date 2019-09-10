package com.test.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


/**
 * <b>  </b>
 * <p>
 * 功能描述:
 * </p>
 * <p/>
 *
 * @author 朱维
 * @date 2018年10月25日
 * @time 上午10:44:06
 * @Path: com.xuebaclass.crm.filter.KeyUserFilter.java
 */
@Component
public class KeyUserFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(KeyUserFilter.class);
    @Override
    public Object run() throws ZuulException {
        System.out.println("zuul过滤器...");
        //向header中添加鉴权令牌
        RequestContext requestContext = RequestContext.getCurrentContext();
        //获取header
        HttpServletRequest request = requestContext.getRequest();
        String authorization = request.getHeader("Authorization");
        if(authorization != null) {
            System.out.println("authorization: " + authorization);
            requestContext.addZuulRequestHeader("Authorization", authorization);
        }
        return null;
    }
    
    @Override
    public boolean shouldFilter() {
        // TODO Auto-generated method stub
        return true; //表示是否需要执行该filter，true表示执行，false表示不执行
    }

    @Override
    public int filterOrder() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String filterType() {
        // TODO Auto-generated method stub
        return "pre"; //定义filter的类型，有pre、route、post、error四种
    }

}
