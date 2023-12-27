package com.example.zhangshangmeishibao.Controller;

import com.example.zhangshangmeishibao.Entity.User;
import com.example.zhangshangmeishibao.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/usr/selectpsw")
    public String Login(@RequestBody User user){
        if(user.getPassword().isEmpty()){
            return "请输入密码";
        }else{
            Optional<User> usr=userRepository.findById(user.getId());
            if(usr.isPresent()) {
                User user1=usr.get();
                return user1.getPassword().equals(user.getPassword())?"登陆成功":"用户或密码错误";
            }else{
                return "账户不存在，请先注册";
            }
        }
    }

    @PostMapping("/usr/insert")
    public String Insert(@RequestBody User user){
        if(user.getId()==null||user.getPassword()==null||user.getPhone()==null){
            return "信息填写不足，请检查";
        }
        else{
            userRepository.save(user);
            return "success";
        }
    }
    @PostMapping("/usr/checkregister")
    public String CheckRegister(@RequestBody User usr){
        Optional<User> user=userRepository.findById(usr.getId());
        return user.isPresent() ? "账号重复" : "可以注册";
    }

    @PostMapping("/usr/edit_user")
    public String Edit_User(@RequestBody User usr){
        userRepository.UpdateUser(usr.getId(),usr.getPassword());
        return "修改成功，请重新登录";
    }
}
