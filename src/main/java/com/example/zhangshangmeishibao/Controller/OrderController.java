package com.example.zhangshangmeishibao.Controller;


import com.example.zhangshangmeishibao.Entity.Order;
import com.example.zhangshangmeishibao.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {


    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/order/select_order")
    public List<Order> Find_Order(@RequestParam String order_id){
        return orderRepository.findOrder(order_id);
    }
    @PostMapping("/order/inser_order")
    public String Insert_Order(@RequestBody Order order){
        orderRepository.save(order);
        return "success";
    }
}
