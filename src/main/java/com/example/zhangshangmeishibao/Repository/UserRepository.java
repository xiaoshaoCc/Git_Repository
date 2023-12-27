package com.example.zhangshangmeishibao.Repository;

import com.example.zhangshangmeishibao.Entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,String> {


    @Modifying
    @Transactional
    @Query(value = "update user set password=?2 where id=?1",nativeQuery = true)
    public int UpdateUser(String ID,String password);

}
