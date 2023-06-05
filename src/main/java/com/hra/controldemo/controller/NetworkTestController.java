package com.hra.controldemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.hra.controldemo.pojo.HraControl;
import com.hra.controldemo.pojo.OrderForm;
import com.hra.controldemo.service.HraControlService;
import com.hra.controldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
//@RequestMapping("/hra")
public class NetworkTestController {

    @Autowired
    private HraControlService hraControlService;
    @Autowired
    private UserService userService;

    @PostMapping(value = "setrule" ,produces = {"application/json;charset=utf-8"})
    public String setRule(@RequestBody OrderForm of){
//        HraControl hraControl = hraControlService.getHraControl(1L);
//        HraControl hraC1 = hraControlService.getHraControlBySid("1234");
//        System.out.println(hraControl);
//        System.out.println(hraC1);
//        List<HraControl> all = hraControlService.getAll();
//        System.out.println(all);
//        System.out.println(1);
        System.out.println(of.getCommand());
        System.out.println(of.getSId());
//        HashMap hashMap = JSONObject.parseObject(of.getCommand(), HashMap.class);

        System.out.println(userService.getUser(1L));
        return "index";
    }
}
