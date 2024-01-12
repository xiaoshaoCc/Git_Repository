package com.example.zhangshangmeishibao.Repository;

import com.example.zhangshangmeishibao.Entity.Comment;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "ALTER TABLE comment AUTO_INCREMENT=1",nativeQuery = true)
    @Transactional
    @Modifying
    public void SetAutoincrement();

    @Query(value = "insert into comment (comment,uploadtime,username,healthy_diet_id)values(?1,?2,?3,?4)",nativeQuery = true)
    @Transactional
    @Modifying
    public int Comment_insert(String comment,String uploadtime,String username,int healthy_diet_id);

    @Query(value = "select * from comment where healthy_diet_id=?1",nativeQuery = true)
    public List<Comment> getComment(int healthy_diet_id);
}
