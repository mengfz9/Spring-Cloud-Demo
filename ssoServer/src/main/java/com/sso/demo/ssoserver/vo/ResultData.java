package com.sso.demo.ssoserver.vo;

import lombok.Data;

@Data
public class ResultData {
    private int state;//操作结果 1:成功，0：失败
    private String message;//提示信息
    private Object data;//数据对象、

    public ResultData(int state,String message,Object data){
        this.state = state;
        this.message = message;
        this.data = data;
    }
    public ResultData(){

    }
}
