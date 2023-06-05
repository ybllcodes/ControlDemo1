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
    @TableField("set_install_package_white_list")
    private String setInstallPackageWhiteList;
    @TableField("set_white_url_list")
    private String setWhiteUrlList;
    @TableField("set_net_firwall")
    private Integer setNetFirwall;
    @TableField("s_mac")
    private String sMac;
    @TableField("p_mac")
    private String pMac;

    public HraControl(String pMac,String sMac){
        this.pMac = pMac;
        this.sMac = sMac;
        init();
    }

    public void init(){
        setNetFirwall = 0;

    }
}








