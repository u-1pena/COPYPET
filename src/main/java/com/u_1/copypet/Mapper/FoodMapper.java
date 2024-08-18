package com.u_1.copypet.Mapper;

import com.u_1.copypet.Entity.Food;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FoodMapper {

  @Insert("INSERT INTO foods (food_name, food_calorie, food_protein, food_fat, food_carbohydrates) VALUES (#{foodName}, #{foodCalorie}, #{foodProtein}, #{foodFat}, #{foodCarbohydrates})")
  void insertFood(Food food);

}
