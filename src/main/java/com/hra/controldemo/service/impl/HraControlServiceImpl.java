package com.hra.controldemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hra.controldemo.mapper.HraControlMapper;
import com.hra.controldemo.pojo.HraControl;
import com.hra.controldemo.service.HraControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HraControlServiceImpl implements HraControlService {

    @Autowired
    private HraControlMapper hraControlMapper;

    @Override
    public List<HraControl> getAll() {
        return hraControlMapper.getAll();
    }

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
    public HraControl getHraControlBySid(String mac) {
        return hraControlMapper.selectOne(new QueryWrapper<HraControl>().eq("sid",mac));
    }

    @Override
    public int updateHraControl(HraControl hraControl) {
        return hraControlMapper.updateById(hraControl);
    }

    @Override
    public int deleteHraControl(Long id) {
        return hraControlMapper.deleteById(id);
    }
}
