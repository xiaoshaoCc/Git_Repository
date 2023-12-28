package com.example.zhangshangmeishibao.Controller;

import com.example.zhangshangmeishibao.Entity.Food;
import com.example.zhangshangmeishibao.Repository.FoodRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/food/get_food")
    public List<Food> GetFood(@RequestParam String window_id){
        return foodRepository.GetFood(window_id, Pageable.unpaged());
    }
    @GetMapping("/food/insert_food")
    @Transactional
    public String Food_insert(@RequestParam("food_name")String food_name,@RequestParam("food_price")Double food_price,
    @RequestParam("window_id")String window_id){
        foodRepository.SetAutoincrement();
        int response=foodRepository.Foodinsert(food_name,food_price,window_id);
        if(response==0){
            return "插入失败";
        }else {
            return "插入成功";
        }
    }

    @GetMapping("/food/food_delete")
    public String Food_delete(@RequestParam("food_id")String food_id){
        Food food=new Food();
        food.setFood_id(food_id);
        foodRepository.delete(food);
        return "success";
    }

    @PostMapping("/food/food_update")
    public String Food_update(@RequestBody Food food){
        foodRepository.save(food);
        return "success";
    }

    @GetMapping("/food/get_food_name")
    public String Get_food_name(@RequestParam String food_id){
       return foodRepository.GetFood_name(food_id);
    }
}
