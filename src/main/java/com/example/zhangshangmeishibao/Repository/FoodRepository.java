package com.example.zhangshangmeishibao.Repository;

import com.example.zhangshangmeishibao.Entity.Food;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,String> {

    @Query(value = "select * from food where window_id=?1",nativeQuery = true)
    public List<Food> GetFood(String window_id, Pageable pageable);

    @Query(value = "ALTER TABLE food AUTO_INCREMENT=1",nativeQuery = true)
    @Transactional
    @Modifying
    public void SetAutoincrement();


    @Query(value = "insert into food (food_name,food_price,window_id)values(?1,?2,?3)",nativeQuery = true)
    @Transactional
    @Modifying
    public int Foodinsert(String name,Double price,String window_id);




}
