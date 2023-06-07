package com.hra.controldemo.service;

import com.hra.controldemo.pojo.HraControl;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HraControlService {

    int saveHraControl(HraControl hc);

    HraControl getHraControl(Long id);

    HraControl getHraControlByMac(String mac);

    HraControl getHraControlByPSMac(String pmac,String smac);

    int updateHraControl(HraControl hraControl);

//    Integer updateHraControl(String mac, String prop, String value);

    int deleteHraControl(Long id);

    List<HraControl> getHcListBypMac(String mac);

    int updateHraControl(String pMac, String sMac, String key, Object value);
}
