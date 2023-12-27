package com.example.zhangshangmeishibao.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class AdministratorLoginController {

    @RequestMapping(value="/Login")
    public String Login(){
        return "AdmistratorLogin";
    }

    @RequestMapping(value = "/Main")
    public String LoginCheck(String username, String password, RedirectAttributes redirectAttributes){
        if(username.equals("123")&&password.equals("123")){
            return "LoginSuccess";
        }else{
            // 将登录失败的信息存储到model中
           redirectAttributes.addFlashAttribute("loginError", "用户名或密码错误");

            // 返回登录页
            return "redirect:/Login";
        }
    }
}
