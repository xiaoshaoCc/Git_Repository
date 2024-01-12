package com.example.zhangshangmeishibao.Controller;

import com.example.zhangshangmeishibao.Entity.Comment;
import com.example.zhangshangmeishibao.Repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @PostMapping("/comment/insert")
    @Transactional
    public String Comment_insert(@RequestBody Comment comment){
        commentRepository.SetAutoincrement();
        int i=commentRepository.Comment_insert(comment.getComment(),comment.getUpload_time(),comment.getUsername(),comment.getHealthy_diet_id());
        if(i>0){
            return "发布成功";
        }else{
            return "发布失败";
        }
    }
    @GetMapping("/comment/get_comment")
    public List<Comment> GetComment(@RequestParam("id") int healthy_diet_id ){
        return commentRepository.getComment(healthy_diet_id);
    }
}
