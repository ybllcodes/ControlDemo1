package com.hra.controldemo.controller;

import com.hra.controldemo.pojo.PtoS;
import com.hra.controldemo.service.PtoSService;
import com.hra.controldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hra/user")
@ResponseBody
public class UserController {
    /*
    绑定连接： 绑定 p_mac | s_mac

    解绑连接： 解绑 p_mac | s_mac
    注册mac： user新增一行
     */

    @Autowired
    private PtoSService ptoSService;
    @Autowired
    private UserService userService;

    public PtoS bandPAndS(String pMac,String sMac){
        PtoS ps = ptoSService.getPsBysMac(sMac);
        if(ps != null){
            //sMac还未绑定，可以与pMac进行绑定
            PtoS newPs = new PtoS(null,pMac,sMac);
            int result = ptoSService.savePtoS(newPs);
            // hControl也需要初始化一行
            return ptoSService.getPsBysMac(sMac);
        }else {
            System.out.println("该sMac已经绑定过！");
            return null;
        }
    }
}
