package com.example.zhangshangmeishibao.Controller;

import com.example.zhangshangmeishibao.Entity.School;
import com.example.zhangshangmeishibao.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @PostMapping("/school/insert")
    public String Insert(@RequestBody School school){
        if(school.getSchool_id() == null || school.getSchool_name() == null){
            return "编号或者名称不能为空";
        }else {
            Optional<School> school1=schoolRepository.findById(school.getSchool_id());
            if(school1.isPresent()){
                return "学校录入重复";
            }else {
                schoolRepository.save(school);
                return "success";
            }
        }
    }
}
