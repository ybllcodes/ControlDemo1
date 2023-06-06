package com.hra.controldemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hra.controldemo.mapper.PtoSMapper;
import com.hra.controldemo.pojo.PtoS;
import com.hra.controldemo.pojo.User;
import com.hra.controldemo.service.PtoSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PtoSServiceImpl implements PtoSService {
    @Autowired
    private PtoSMapper ptoSMapper;
    @Override
    public int savePtoS(PtoS ps) {
        return ptoSMapper.insert(ps);
    }

    @Override
    public PtoS getPtoS(Long id) {
        return ptoSMapper.selectById(id);
    }

    @Override
    public List<PtoS> getSsBypMac(String pMac) {
        Wrapper<PtoS> wp = new QueryWrapper<PtoS>().eq("p_mac",pMac);
        List<PtoS> pss = ptoSMapper.selectList(wp);
        return pss;
    }

    @Override
    public PtoS getPsBysMac(String sMac) {
        Wrapper<PtoS> wrapper = new QueryWrapper<PtoS>().eq("s_mac",sMac);
        PtoS ptoS = ptoSMapper.selectOne(wrapper);
        return ptoS;
    }

    @Override
    public int updatePtoS(PtoS ps) {
        return ptoSMapper.updateById(ps);
    }

    @Override
    public int deletePtoS(Long id) {
        return ptoSMapper.deleteById(id);
    }
}
