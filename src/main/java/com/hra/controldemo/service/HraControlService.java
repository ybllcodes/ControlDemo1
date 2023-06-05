package com.hra.controldemo.service;

import com.hra.controldemo.pojo.HraControl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HraControlService {

    List<HraControl> getAll();
    int saveHraControl(HraControl hc);

    HraControl getHraControl(Long id);

    HraControl getHraControlBySid(String mac);

    int updateHraControl(HraControl hraControl);

    int deleteHraControl(Long id);

}
