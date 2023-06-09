package com.hra.controldemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hra.controldemo.mapper.HraControlMapper;
import com.hra.controldemo.pojo.HraControl;
import com.hra.controldemo.service.HraControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
public class HraControlServiceImpl implements HraControlService {

    @Autowired
    private HraControlMapper hraControlMapper;



    @Override
    public int saveHraControl(HraControl hc) {
        return hraControlMapper.insert(hc);
    }

    @Override
    public HraControl getHraControl(Long id) {
        System.out.println("HraControlServiceImpl - " + id);
        return hraControlMapper.selectById(id);
    }

    @Override
    public HraControl getHraControlByMac(String mac) {
        return hraControlMapper.selectOne(new QueryWrapper<HraControl>().eq("stu_mac",mac));
    }

    @Override
    public HraControl getHraControlByPSMac(String pmac, String smac) {
        QueryWrapper<HraControl> wra = new QueryWrapper<HraControl>().eq("stu_mac", smac).eq("par_mac",pmac);
//        new QueryWrapper<HraControl>().eq("par_mac", pmac);

        return hraControlMapper.selectOne(wra);
    }

    @Override
    public int updateHraControl(HraControl hraControl) {
//        hraControlMapper
        return hraControlMapper.updateById(hraControl);
    }

//    @Override
//    public Integer updateHraControl(String mac, String prop, String value) {
//        return hraControlMapper.update(mac,prop,value);
//    }
    @Override
    public int updateHraControl(String pMac, String sMac, String key, Object value) {
        return hraControlMapper.update(pMac,sMac,key,value);
    }

    @Override
    public int deleteHraControl(Long id) {
        return hraControlMapper.deleteById(id);
    }

    @Override
    public List<HraControl> getHcListBypMac(String mac) {
        Wrapper<HraControl> wrapper = new QueryWrapper<HraControl>().eq("par_mac",mac);
        List<HraControl> hraControls = hraControlMapper.selectList(wrapper);
        return hraControls;
    }


}
