package com.hra.controldemo.controller;

import com.hra.controldemo.pojo.HraControl;
import com.hra.controldemo.service.HraControlService;
import com.hra.controldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hra/control")
public class RuleController {
    @Autowired
    private HraControlService hraControlService;
    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/setrule")
    public void setRule(@RequestBody HraControl hc){

        System.out.println(hc.getPMac());
        System.out.println(hc.getSMac());
        System.out.println(hc);

        HraControl hraControl = hraControlService.getHraControlByMac(hc.getSMac());
        if(hraControl != null){
            //更新管控信息
//            System.out.println(hraControl.getPMac() + " === " + hraControl.getSetNetFirwall());
            System.out.println(hraControl);
            hc.setId(hraControl.getId());
            hraControlService.updateHraControl(hc);
        }else {
            //插入管控信息
//            HraControl newHc = new HraControl("abc1","abc2");
//            hraControlService.saveHraControl(newHc);

        }
    }

}
