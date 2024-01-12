package com.example.zhangshangmeishibao.Repository;


import com.example.zhangshangmeishibao.Entity.Appversions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<Appversions,Integer> {
}
