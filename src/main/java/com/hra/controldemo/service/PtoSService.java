package com.hra.controldemo.service;

import com.hra.controldemo.pojo.PtoS;

import java.util.List;

public interface PtoSService {
    int savePtoS(PtoS ps);

    PtoS getPtoS(Long id);

    List<PtoS> getSsBypMac(String pMac);

    PtoS getPsBysMac(String sMac);
    PtoS getPsOnStatusBysMac(String sMac);

    PtoS getPsByPSMac(String pMac,String sMac);

    int updatePtoS(PtoS ps);

    int deletePtoS(Long id);

    PtoS getSsByPSMac(String parMac, String stuMac);

    String isBindOfsMac(String stuMac);

    String getBinderPMac(String stuMac);
}
