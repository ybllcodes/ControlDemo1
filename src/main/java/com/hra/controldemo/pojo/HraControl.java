package com.hra.controldemo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("hracontrol")
public class HraControl implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String sid;

    private String appInstallList;
    private String networkUrlList;
    private Integer networkControl;
    private Integer wifiSwitch;
}
