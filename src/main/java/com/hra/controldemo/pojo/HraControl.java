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

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private Integer status;
    private String setInstallPackageWhiteList;
    private String setWhiteUrlList;
    private Integer setNetFirwall;

    private String stuMac;
    private String parMac;

    public HraControl(String pMac,String sMac){
        this.parMac = pMac;
        this.stuMac = sMac;
        init();
    }

    public void init(){
        status = 1;

        setNetFirwall = 0;
    }
}








