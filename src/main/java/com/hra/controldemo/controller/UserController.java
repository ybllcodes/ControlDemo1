package com.hra.controldemo.controller;

import com.hra.controldemo.pojo.HraControl;
import com.hra.controldemo.pojo.PtoS;
import com.hra.controldemo.pojo.ResultBean;
import com.hra.controldemo.pojo.User;
import com.hra.controldemo.service.HraControlService;
import com.hra.controldemo.service.PtoSService;
import com.hra.controldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

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
    @Autowired
    private HraControlService hraControlService;

    @ResponseBody
    @PostMapping("/bindPS")
    public void bindPAndS(@RequestBody Map<String,String> params){
        String stuMac = params.getOrDefault("stuMac","");
        String parMac = params.getOrDefault("parMac","");

        User parUser = userService.getUserByMac(parMac);
        User stuUser = userService.getUserByMac(stuMac);
        if (stuUser == null || parUser == null){
            System.out.println("mac地址未注册，请先注册");
            return;
        }

        PtoS OnPs = ptoSService.getPsOnStatusBysMac(stuMac);
        if (OnPs != null){
            // 当前 stuMac已经绑定，存在有status为1的管控Mac
            System.out.println("绑定失败！该SMac已经绑定过,请先解绑");
            return;
        }else {
            PtoS ps = ptoSService.getPsByPSMac(parMac,stuMac);
            //当前 stuMac未进行绑定，可以绑定
            if(ps == null){
                //新增一条数据记录
                Integer parType = parUser.getType();
                Integer stuType = stuUser.getType();
                if(parType != 0){
                    System.out.println("pMac 没权限");
                    return;
                }
                if(stuType != 1){
                    System.out.println("sMac 传入错误");
                    return;
                }
                PtoS newPs = new PtoS(null,1,parMac,stuMac);
                int result = ptoSService.savePtoS(newPs);
                // hControl也需要初始化
                HraControl hraControl = new HraControl(parMac, stuMac);
                hraControlService.saveHraControl(hraControl);
                System.out.println("已创建pMac与sMac的绑定关系");
            }else {
                //此前存在记录，直接修改status状态
                ps.setStatus(1);
                ptoSService.updatePtoS(ps);
                //修改HControl状态
                HraControl hc = hraControlService.getHraControlByPSMac(parMac, stuMac);
                hc.setStatus(1);
                hraControlService.updateHraControl(hc);
                System.out.println("pMac与sMac已重新绑定");
            }
        }
    }

    @ResponseBody
    @PostMapping("/unbindPS")
    public void unbindPAndS(@RequestBody Map<String,String> params){
        String stuMac = params.getOrDefault("stuMac","");
        String parMac = params.getOrDefault("parMac","");
        User parUser = userService.getUserByMac(parMac);
        User stuUser = userService.getUserByMac(stuMac);
        if (stuUser == null || parUser == null){
            System.out.println("mac地址未注册，请先注册");
            return;
        }
        PtoS ps = ptoSService.getSsByPSMac(parMac, stuMac);
        if(ps != null){
            //配对成功，判断status状态
            if(ps.getStatus() == 1){
                //处于绑定状态，可以解绑
                ps.setStatus(0);
                int result = ptoSService.updatePtoS(ps);
                // hControl也需要删除一行
                HraControl hc = hraControlService.getHraControlByPSMac(parMac, stuMac);
                hc.setStatus(0);
                hraControlService.updateHraControl(hc);
                System.out.println("pMac与sMac已解绑！");
            }else {
                //已经解绑过
                System.out.println("该pMac与sMac已经解绑了！");
            }
        }else {
            //pmac与smac无法配对，解绑失败
            System.out.println("该pMac与sMac配对失败，解绑失败！");
        }
    }

    @ResponseBody
    @PostMapping("/registermac")
    public ResultBean registerMac(@RequestBody Map<String,String> params){
        String mac = params.getOrDefault("mac","");
        String type = params.getOrDefault("type","1"); //0:家长端 1:学生端
        System.out.println("mac:" + mac + " ,type:" + type);
        User user = userService.getUserByMac(mac);
        if(user == null){
            //当前mac未注册
            User user1 = new User(null,0,"name" + mac,mac,"1".equals(type)? 1 :0);
            userService.saveUser(user1);
            System.out.println("注册成功!");
            return new ResultBean(true,"注册成功","123",1);
        }else {
            //已经注册
            System.out.println("当前mac已经注册,不用再次注册");
            return new ResultBean(true,"当前mac已经注册,不需要再次注册","345",1);
        }
    }
}
