package com.hra.controldemo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("hcontrol")
public class HraControl implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String setInstallPackageWhiteList;
    private String setWhiteUrlList;
    private Integer setNetFirwall;

    private String sMac;

    private String pMac;

    public HraControl(String pMac,String sMac){
        this.pMac = pMac;
        this.sMac = sMac;
        init();
    }

    public void init(){

    }
}








