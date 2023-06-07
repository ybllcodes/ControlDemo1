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
    private String stuMac;
    private String parMac;

    private String setInstallPackageWhiteList;
    private Integer setNetFirwall = 0;
    private String setWhiteUrlList;
    private String setWhiteNetApp;
    private String setDisallowedRunningApp;
    private String setKeepAliveList;
    private String setDisUninstallAppList;
    private String setDefaultLauncher;
    private Integer clearLauncher = 1;
    private Integer setCameraDisabled=0;
    private Integer setBluetoothDisable=0;
    private Integer setGpsDisable=0;
    private Integer turnOnGps = 1;
    private Integer turnOnAdb = 1;


    public HraControl(String pMac,String sMac){
        this.parMac = pMac;
        this.stuMac = sMac;
        init();
    }
    public void init(){
        status = 1;
    }
}








