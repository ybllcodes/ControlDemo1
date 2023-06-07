package com.hra.controldemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hra.controldemo.pojo.HraControl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface HraControlMapper extends BaseMapper<HraControl> {

//    @Select("update hcontrol set ${prop} = ${value} where s_mac = ${mac};")
//    Integer update(String mac, String prop, String value);

    @Update("update hcontrol set ${prop} = ${value} where stu_mac = '${sMac}' and par_mac='${pMac}';")
    Integer update(String pMac, String sMac,String prop, Object value);
}
