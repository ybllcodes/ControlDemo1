package com.hra.controldemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hra.controldemo.mapper.PtoSMapper;
import com.hra.controldemo.pojo.HraControl;
import com.hra.controldemo.pojo.PtoS;
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
    //由pMac获取List<PtoS>
    public List<PtoS> getSsBypMac(String pMac) {
        Wrapper<PtoS> wp = new QueryWrapper<PtoS>().eq("par_mac",pMac);
        List<PtoS> pss = ptoSMapper.selectList(wp);
        return pss;
    }

    @Override
    public PtoS getPsBysMac(String sMac) {
        Wrapper<PtoS> wrapper = new QueryWrapper<PtoS>().eq("stu_mac",sMac);
        PtoS ptoS = ptoSMapper.selectOne(wrapper);
        return ptoS;
    }

    @Override
    public PtoS getPsOnStatusBysMac(String sMac) {
        Wrapper<PtoS> wrapper = new QueryWrapper<PtoS>().eq("stu_mac",sMac).eq("status",1);
        PtoS ptoS = ptoSMapper.selectOne(wrapper);
        return ptoS;
    }

    @Override
    public PtoS getPsByPSMac(String pMac,String sMac) {
        Wrapper<PtoS> wrapper = new QueryWrapper<PtoS>().eq("stu_mac",sMac).eq("par_mac",pMac);
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

    @Override
    public PtoS getSsByPSMac(String parMac, String stuMac) {
        QueryWrapper<PtoS> wra = new QueryWrapper<PtoS>().eq("stu_mac", stuMac).eq("par_mac",parMac);

        return ptoSMapper.selectOne(wra);
    }

    @Override
    public String isBindOfsMac(String stuMac) {
//        ptoSMapper.selectList();
        return null;
    }

    @Override
    public String getBinderPMac(String stuMac) {
//        ptoSMapper.selectOne();
        return null;
    }
}
