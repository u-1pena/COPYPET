package com.u_1.copypet.Mapper;

import com.u_1.copypet.Entity.Food;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface FoodMapper {

  @Insert("INSERT INTO foods (food_name, food_calories, food_protein, food_fat, food_carbohydrates) VALUES (#{foodName}, #{foodCalories}, #{foodProtein}, #{foodFat}, #{foodCarbohydrates})")
  @Options(useGeneratedKeys = true, keyProperty = "foodId")
  void insertFood(Food food);

}
