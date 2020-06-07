package com.sso.demo.ssoserver.controller;

import com.sso.demo.ssoserver.service.SsoService;
import com.sso.demo.ssoserver.vo.ResultData;
import com.sso.demo.ssoserver.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class SsoController {

    @Autowired
    private SsoService ssoService;

    /**
     * 登录接口
     * @param username 账号
     * @param password 密码
     * @return
     */
    @GetMapping(value = "login/{username}/{password}")
    public ResultData userLogin(@PathVariable("username") String username, @PathVariable("password") String password) {
        UserVo userVo = ssoService.checkLogin(username,password);
        if(userVo!=null && userVo.getId() != null ){
            return new ResultData(1,"登录成功",userVo);
        }
        return new ResultData(1,"登录失败",userVo);
    }

}
