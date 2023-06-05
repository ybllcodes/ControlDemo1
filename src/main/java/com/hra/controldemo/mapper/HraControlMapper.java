package com.hra.controldemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hra.controldemo.pojo.HraControl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface HraControlMapper extends BaseMapper<HraControl> {

    @Select("update hcontrol set ${prop} = ${value} where s_mac = ${mac};")
    Integer update(String mac, String prop, String value);
}
