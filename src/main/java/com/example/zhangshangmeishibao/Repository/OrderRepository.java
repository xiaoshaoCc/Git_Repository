package com.example.zhangshangmeishibao.Repository;

import com.example.zhangshangmeishibao.Entity.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,String> {

    @Query(value = "select * from orders where user_id=?1",nativeQuery = true)
    List<Order> findOrder(String userId);

    @Modifying
    @Transactional
    @Query(value = "insert into orders values(?,?,?,?,?,?)",nativeQuery = true)
    public int Insert_Order(String order_id,String user_id,String order_date, String order_price,String order_status ,String window_id);

    @Query(value = "select order_id,user_id,order_date,order_price,order_status,orders.window_id " +
            "from orders,windows,merchant where windows.merchant=?1 and windows.window_id=orders.window_id and orders.order_status=\"已支付\"",nativeQuery = true)
    public List<Order> Merchant_Getorder(String merchant_id);

    @Modifying
    @Transactional
    @Query(value = "update orders set order_status=?1 where order_id=?2",nativeQuery = true)
    public void Update_Order(String order_status,String order_id);
}
