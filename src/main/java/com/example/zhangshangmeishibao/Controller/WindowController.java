package com.example.zhangshangmeishibao.Controller;


import com.example.zhangshangmeishibao.Entity.Merchant;
import com.example.zhangshangmeishibao.Entity.School;
import com.example.zhangshangmeishibao.Entity.Window;
import com.example.zhangshangmeishibao.Repository.MerchantRepository;
import com.example.zhangshangmeishibao.Repository.SchoolRepository;
import com.example.zhangshangmeishibao.Repository.WindowReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class WindowController {

    @Autowired
    private WindowReporsitory windowReporsitory;
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private MerchantRepository merchantRepository;

    //管理端逻辑验证
    @PostMapping("/window/insert")
    public String Insert(@RequestBody Window window){
        if(window.getWindow_id()==null||window.getWindow_name()==null
        ||window.getMerchant()==null||window.getSchool_id()==null){
            return "数据填写不完全，请重新填写";
        }
        else {
            Optional<School> school=schoolRepository.findById(window.getSchool_id());
            Optional<Merchant> merchant=merchantRepository.findById(window.getMerchant());
            Optional<Window> window1=windowReporsitory.findById(window.getWindow_id());
            if(window1.isPresent()){
                return "窗口已注册";
            }
            if(school.isEmpty()){
                return "学校不存在";
            }else if(merchant.isEmpty()){
                return "商家不存在";
            }
            windowReporsitory.save(window);
            return "success";
        }
    }

    @RequestMapping("/window/windowlist")
    public List<Window> WindowList(){
        return windowReporsitory.findAll();
    }

    @GetMapping("window/window_status")
    public String  WindowStatus_Change(@RequestParam("window_status")String window_status, @RequestParam("window_id")String window_id){
        int num=windowReporsitory.WindowstatusChange(window_status, window_id);
        if(num==0){
            return "false";
        }else {
            return "success";
        }

    }


}
