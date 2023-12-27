package com.example.zhangshangmeishibao.Controller;

import com.example.zhangshangmeishibao.Entity.Merchant;
import com.example.zhangshangmeishibao.Repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class MerchantController {

    @Autowired
    private MerchantRepository merchantRepository;


    @PostMapping("/merchant/selectpsw")
    public String Login(@RequestBody Merchant merchant){
        if(merchant.getMerchant_password().isEmpty()){
            return "请输入密码";
        }else{
            Optional<Merchant> merchant1=merchantRepository.findById(merchant.getMerchant_id());
            if(merchant1.isPresent()) {
                Merchant merchant2=merchant1.get();
                return merchant2.getMerchant_password().equals(merchant.getMerchant_password())?"登陆成功":"用户或密码错误";
            }else{
                return "账户不存在，请先注册";
            }
        }
    }

    @PostMapping("/merchant/insert")
    public String Insert(@RequestBody Merchant merchant){
        if(merchant.getMerchant_id()==null||merchant.getMerchant_password()==null||merchant.getMerchant_phone()==null){
            return "信息填写不足，请检查";
        }
        else{
            merchantRepository.save(merchant);
            return "success";
        }
    }
    @PostMapping("/merchant/checkregister")
    public String CheckRegister(@RequestBody Merchant merchant){
        Optional<Merchant> merchant1=merchantRepository.findById(merchant.getMerchant_id());
        return merchant1.isPresent() ? "账号重复" : "可以注册";
    }
}
