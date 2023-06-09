package com.hra.controldemo.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.api.R;
import com.hra.controldemo.pojo.HraControl;
import com.hra.controldemo.pojo.PtoS;
import com.hra.controldemo.pojo.ResultBean;
import com.hra.controldemo.pojo.User;
import com.hra.controldemo.service.HraControlService;
import com.hra.controldemo.service.PtoSService;
import com.hra.controldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public ResultBean setRule(@RequestBody HraControl hc) {

        System.out.println(hc);
//        Set<String> keys = params.keySet();
        String pMac = hc.getParMac();
        String sMac = hc.getStuMac();
        HraControl hraControl = hraControlService.getHraControlByPSMac( pMac, sMac);
//        for (String key : keys) {
//            if("parMac".equals(key) || "stuMac".equals(key)){
//                continue;
//            }
//            hraControlService.updateHraControl(pMac,sMac,key,params.get(key));
//        }
        if (hraControl != null) {
            //更新管控信息
//            System.out.println(hraControl.getPMac() + " === " + hraControl.getSetNetFirwall());
            System.out.println(hraControl);
            hc.setId(hraControl.getId());
            hraControlService.updateHraControl(hc);
            return new ResultBean("推送成功!");
        } else {
            //当前stuMac没关联，不能管控
            return new ResultBean("推送失败！");
        }
    }

    @ResponseBody
    @PostMapping("/getmsgfs")
    public ResultBean getMsgFromS(@RequestBody Map<String, String> params) {
        String stuMac = params.getOrDefault("stuMac", "");
        User stuUser = userService.getUserByMac(stuMac);
        if (stuUser == null) {
            System.out.println("sMac地址未注册，请先注册");
            return new ResultBean("sMac地址未注册,请先注册");
        } else if (stuUser.getType() != 1) {
            System.out.println("sMac不属于学生端");
            return new ResultBean("sMac不属于学生端");
        }
        if (!params.containsKey("parMac")) {
            //没有 parMac,直接匹配 status为 1的管控
            PtoS ps = ptoSService.getPsOnStatusBysMac(stuMac);
            HraControl hc = hraControlService.getHraControlByPSMac(ps.getParMac(), ps.getParMac());
            String s = JSON.toJSONString(hc);
            return new ResultBean(true, "请求管控成功!", s , 5);
        }
        String parMac = params.getOrDefault("parMac", "");
        System.out.println("pmac:" + params + " ,smac:" + stuMac);
        User parUser = userService.getUserByMac(parMac);
        if (parUser == null) {
            System.out.println("pMac地址未注册，请先注册");
            return new ResultBean("pMac地址未注册,请先注册");
        } else if (parUser.getType() != 0) {
            System.out.println("pMac不属于家长端");
            return new ResultBean("pMac不属于家长端");
        }

        HraControl hc = hraControlService.getHraControlByPSMac(parMac, stuMac);
        System.out.println(hc);
        if (hc != null) {
            if (hc.getStatus() == 1) {
                //匹配成功，返回hc
                System.out.println("请求管控成功");
                String s = JSON.toJSONString(hc);
                System.out.println(s);
                return new ResultBean(true, "请求管控成功!", s, 5);
            }
            System.out.println("sMac与pMac未处于管控状态");
            return new ResultBean("sMac与pMac未处于管控状态");
        } else {
            System.out.println("sMac与pMac不匹配");
            return new ResultBean("sMac与pMac不匹配");
        }
    }

    @ResponseBody
    @PostMapping("/getmsgfp")
    public ResultBean getMsgFromP(@RequestBody Map<String, String> params) {
        String parMac = params.getOrDefault("parMac", "");
        System.out.println("pmac:" + params);
        User PUser = userService.getUserByMac(parMac);
        if (PUser == null && PUser.getType() != 0) {
            System.out.println("传入的Mac有误！");
            return new ResultBean(false, "传入的Mac有误", 1);
        }
        //查询绑定了多少子 mac
        List<PtoS> psList = ptoSService.getSsBypMac(parMac);

        //查询该pmac 的管控信息
        List<HraControl> hcList = hraControlService.getHcListBypMac(parMac);
        String s = JSON.toJSONString(hcList);
        return new ResultBean(true, "pMac查询HControl-List成功", s, 10);
    }
}
