package com.example.zhangshangmeishibao.Repository;

import com.example.zhangshangmeishibao.Entity.Healthydiet;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HealthydietRepository extends JpaRepository<Healthydiet, Integer> {

    @Query(value = "ALTER TABLE healthy_diet AUTO_INCREMENT=1",nativeQuery = true)
    @Transactional
    @Modifying
    public void SetAutoincrement();

    @Query(value = "insert into healthy_diet (title,healthtext,uploadtime,username,status)values(?1,?2,?3,?4,?5)",nativeQuery = true)
    @Transactional
    @Modifying
    public int Healthy_diet_insert(String title,String healthtext,String uploadtime,String username,String status);

    @Query(value = "select * from healthy_diet where status='已通过'",nativeQuery = true)
    public List<Healthydiet> Findall1();

    @Query(value = "select *from healthy_diet where username=?1",nativeQuery = true)

    public List<Healthydiet> FindmyALL(String username);


}
