package com.nfgj.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author nanfgj
 * @create 2022-07-26 17:42
 */
@Order(-1) //设置过滤器优先级，值越低优先级越高
@Component
public class AuthorizeFilter  implements GlobalFilter {

    // 测试：http://localhost:10010/order/101?authorization=admin
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.获取第一个authorization参数
        String auth = exchange.getRequest().getQueryParams().getFirst("authorization");
        //2.验证authorization参数是否符合
        if ("admin".equals(auth)){
            //3.符合放行
            return chain.filter(exchange);
        }
        //4.不符合，进行拦截
        //设置拦截信息码
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        //设置拦截
        return exchange.getResponse().setComplete();
    }
}
