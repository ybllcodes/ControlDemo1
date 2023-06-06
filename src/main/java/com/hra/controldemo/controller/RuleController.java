package com.hra.controldemo.controller;

import com.hra.controldemo.pojo.HraControl;
import com.hra.controldemo.pojo.PtoS;
import com.hra.controldemo.service.HraControlService;
import com.hra.controldemo.service.PtoSService;
import com.hra.controldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hra/control")
public class RuleController {
    @Autowired
    private HraControlService hraControlService;
    @Autowired
    private UserService userService;

    @Autowired
    private PtoSService ptoSService;

    @ResponseBody
    @PostMapping("/setrule")
    public void setRule(@RequestBody HraControl hc){

        System.out.println(hc);
        HraControl hraControl = hraControlService.getHraControlByMac(hc.getStuMac());
        if(hraControl != null){
            //更新管控信息
//            System.out.println(hraControl.getPMac() + " === " + hraControl.getSetNetFirwall());
            System.out.println(hraControl);
            hc.setId(hraControl.getId());
            hraControlService.updateHraControl(hc);
        }else {
            //当前stuMac没关联，不能管控
        }
    }

    @ResponseBody
    @PostMapping("/getmsgfs")
    public HraControl getMsgFromS(@RequestBody Map<String,String> params){
        String stuMac = params.getOrDefault("stuMac","");
        String parMac = params.getOrDefault("parMac","");
        System.out.println("pmac:" +  params+ " ,smac:" + stuMac);


        HraControl hc = hraControlService.getHraControlByPSMac(parMac, stuMac);
        System.out.println(hc);
        if(hc!=null){
            //匹配成功，返回hc
            System.out.println("请求管控成功");
            return hc;
        }else {
            return null;
        }
    }

    @ResponseBody
    @PostMapping("/getmsgfp")
    public List<HraControl> getMsgFromP (@RequestBody Map<String,String> params){
        String parMac = params.getOrDefault("parMac","");
        System.out.println("pmac:" + params);

        //查询绑定了多少子 mac
        List<PtoS> psList = ptoSService.getSsBypMac(parMac);

        //查询该pmac 的管控信息
        List<HraControl> hcList = hraControlService.getHcListBypMac(parMac);
        return hcList;
    }
}
