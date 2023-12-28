package com.example.zhangshangmeishibao.Repository;

import com.example.zhangshangmeishibao.Entity.Order_detail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Order_detailRepository extends JpaRepository<Order_detail,String> {

    @Query(value = "ALTER TABLE order_detail AUTO_INCREMENT=1",nativeQuery = true)
    @Transactional
    @Modifying
    public void SetAutoincrement();

    @Modifying
    @Transactional
    @Query(value = "insert into order_detail values(?,?,?,?)",nativeQuery = true)
    public int Insert_Order_detail(String detail_id,String order_id,String food_id,String food_quality);

    @Query(value = "select * from order_detail where order_id=?1",nativeQuery = true)
    public List<Order_detail> Get_Order_detail(String order_id);

}
