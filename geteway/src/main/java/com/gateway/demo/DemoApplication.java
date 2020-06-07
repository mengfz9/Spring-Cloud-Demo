package com.gateway.demo;

import com.gateway.demo.filters.UserLoginZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy  //支持zull路由
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    //将过滤器加入到spring容器
//    @Bean
//    public UserLoginZuulFilter userLoginZuulFilter(){
//        return new UserLoginZuulFilter();
//    }
}
