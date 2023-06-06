package com.hra.controldemo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PtoS {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String pMac;
    private String sMac;
}
