package com.hra.controldemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean flag;
    private String msg;

    private String result;

    private Integer msgType;

    public ResultBean(boolean flag, String msg,Integer msgType) {
        this.flag = flag;
        this.msg = msg;
        this.msgType = msgType;
    }

    public ResultBean(String msg){
        this.flag = true;
        this.msg = msg;
        this.msgType = 1;
    }
}
