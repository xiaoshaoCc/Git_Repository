package com.example.zhangshangmeishibao.Repository;


import com.example.zhangshangmeishibao.Entity.Window;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface WindowReporsitory extends JpaRepository<Window,String> {
    @Transactional
    @Modifying
    @Query(value = "update windows set window_status=?1 where window_id=?2 ",nativeQuery = true)
    public int WindowstatusChange(String status,String id);

}
