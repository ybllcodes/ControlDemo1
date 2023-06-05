package com.hra.controldemo.service;

import com.hra.controldemo.pojo.HraControl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HraControlService {

    List<HraControl> getAll();
    int saveHraControl(HraControl hc);

    HraControl getHraControl(Long id);

    HraControl getHraControlByMac(String mac);

    int updateHraControl(HraControl hraControl);

    Integer updateHraControl(String mac, String prop, String value);

    int deleteHraControl(Long id);

}
