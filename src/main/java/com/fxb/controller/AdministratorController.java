package com.fxb.controller;

import com.fxb.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdministratorController {
    @Autowired
    IndexService service;

    //管理员登录完成之后可以进入页面管理
    @RequestMapping(value = "/admin")
    public String Admin(HttpSession session) {
        List list = service.getPermission();
        session.setAttribute("s_name","admin");
        session.setAttribute("users",list);

        return "/front/admin";
    }

    //禁言用户
    @ResponseBody
    @RequestMapping(value = "/banned")  // 这个是一种新的传参方式
     public String Banned(@RequestParam Integer s_id) {
//        System.out.println("有没有执行到这里哇");
        service.banned(s_id);
//        return "/front/admin";
        return  "true";
     }

     //解除禁言
    @ResponseBody
    @RequestMapping(value = "/belease")
    public String Belease(@RequestParam Integer s_id) {
         service.belease(s_id);
//         return  "/front/admin";
        return "false";
    }

}
