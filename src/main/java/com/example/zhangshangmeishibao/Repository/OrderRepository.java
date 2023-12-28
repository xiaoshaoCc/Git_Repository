package com.example.zhangshangmeishibao.Repository;

import com.example.zhangshangmeishibao.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,String> {

    @Query(value = "select * from order where order_id=?1",nativeQuery = true)
    List<Order> findOrder(String orderId);
}
