package com.hra.controldemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.hra.controldemo.pojo.HraControl;
import com.hra.controldemo.service.HraControlService;
import com.hra.controldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.metal.MetalTheme;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/hra")
@ResponseBody
public class NetworkTestController {

    @Autowired
    private HraControlService hraControlService;
    @Autowired
    private UserService userService;

    @PostMapping(value = "setrule" ,produces = {"application/json;charset=utf-8"})
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
            HraControl newHc = new HraControl("abc1","abc2");
            hraControlService.saveHraControl(newHc);

        }
    }
}
