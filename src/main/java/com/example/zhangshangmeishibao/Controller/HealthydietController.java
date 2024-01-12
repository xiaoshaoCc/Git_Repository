package com.example.zhangshangmeishibao.Controller;


import com.example.zhangshangmeishibao.Entity.Healthydiet;
import com.example.zhangshangmeishibao.Repository.HealthydietRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HealthydietController {

    @Autowired
    private HealthydietRepository healthydietRepository;

    @PostMapping("/healthydiet/insert")
    @Transactional
    public String insertHealthydiet(@RequestBody Healthydiet healthydiet){
        healthydietRepository.SetAutoincrement();
        int i=healthydietRepository.Healthy_diet_insert(healthydiet.getTitle(),healthydiet.getHealthtext(),healthydiet.getUploadtime(),healthydiet.getUsername(),"待审核");
        if(i!=0){
            return "上传成功，待审核";
        }else {
            return "插入失败";
        }
    }

    @GetMapping("/healthydiet/findall")
    public List<Healthydiet> Findall(){
        return healthydietRepository.Findall1();
    }

    @GetMapping("/healthydiet/findmyall")
    public List<Healthydiet> FindMyall(String username){
        return healthydietRepository.FindmyALL(username);
    }
}
