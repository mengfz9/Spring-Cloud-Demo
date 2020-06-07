package com.sso.demo.ssoserver.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sso.demo.ssoserver.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SsoService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "checkUserFallbackMethod") // 进行容错处理
    public UserVo checkLogin(String username,String password){
        String serviceId = "microservice-user"; //用户服务名
        //请求用户服务中查找用户方法的url
        String url = "http://" + serviceId + "/user/" + username;
        UserVo userVo = restTemplate.getForObject(url,UserVo.class);
        if (userVo!=null){
            String pw = userVo.getPassword();
            if (password.equals(pw)){
                return userVo;
            }
        }
        return null;
    }

    public UserVo checkUserFallbackMethod(String username,String password){ // 请求失败执行的方法
        return new UserVo(null, "网络错误，请稍后再试！", null, null, null,null,null,null,null);
    }
}
