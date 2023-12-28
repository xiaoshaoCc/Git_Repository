package com.example.zhangshangmeishibao.Controller;


import com.example.zhangshangmeishibao.Entity.Order;
import com.example.zhangshangmeishibao.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {


    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/order/select_order")
    public List<Order> Find_Order(@RequestParam String user_id){
        return orderRepository.findOrder(user_id);
    }
    @PostMapping("/order/insert_order")
    public String Insert_Order(@RequestBody Order order){
        orderRepository.Insert_Order(order.getOrder_id(),order.getUser_id(),order.getOrder_date(),order.getOrder_price().toString(), order.getOrder_status(),order.getWindow_id());
        return "success";
    }
    @PostMapping("/order/findById")
    public String Order_status(@RequestBody Order order){
        Order order1=order;
        orderRepository.Update_Order(order.getOrder_status(),order.getOrder_id());
        return "success";
    }

    @GetMapping("/order/merchant_order")
    public List<Order> Merchant_Get_Order(@RequestParam("merchant_id") String merchant_id){
        return orderRepository.Merchant_Getorder(merchant_id);
    }
}
