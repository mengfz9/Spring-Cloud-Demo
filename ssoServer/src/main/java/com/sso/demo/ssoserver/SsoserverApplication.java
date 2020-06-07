package com.sso.demo.ssoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@EnableHystrix //容错
@EnableDiscoveryClient //从eureka server中获取注册列表
@SpringBootApplication
public class SsoserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoserverApplication.class, args);
    }

    @Bean // 向Spring容器中定义RestTemplate对象
    @LoadBalanced //取出服务列表进行负载均衡算法
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
