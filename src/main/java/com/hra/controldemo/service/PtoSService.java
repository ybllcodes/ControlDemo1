package com.hra.controldemo.service;

import com.hra.controldemo.pojo.PtoS;
import com.hra.controldemo.pojo.User;

import java.util.List;

public interface PtoSService {
    int savePtoS(PtoS ps);

    PtoS getPtoS(Long id);

    List<PtoS> getSsBypMac(String pMac);

    PtoS getPsBysMac(String sMac);

    int updatePtoS(PtoS ps);

    int deletePtoS(Long id);
}
