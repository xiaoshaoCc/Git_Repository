package com.example.zhangshangmeishibao.Controller;

import com.example.zhangshangmeishibao.Entity.Order_detail;
import com.example.zhangshangmeishibao.Repository.Order_detailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Order_detail_Controller {


    @Autowired
    private Order_detailRepository order_detailRepository;

    @PostMapping("/order_detail/insert")
    @Transactional
    public String Insert_Order_detail(@RequestBody Order_detail orderDetail){
        order_detailRepository.SetAutoincrement();
        order_detailRepository.Insert_Order_detail(orderDetail.getDetail_id()
        ,orderDetail.getOrder_id(),orderDetail.getFood_id(),orderDetail.getFood_quality());
        return "success";
    }

    @GetMapping("/order_detail/getdetail")
    public List Get_Detail(@RequestParam String order_id){
        return order_detailRepository.Get_Order_detail(order_id);
    }

}
