package com.hra.controldemo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("ptos")
public class PtoS {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Integer status;
    private String parMac;
    private String stuMac;
}
