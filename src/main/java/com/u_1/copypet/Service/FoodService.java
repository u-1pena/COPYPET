package com.u_1.copypet.Service;

import com.u_1.copypet.Entity.Food;
import com.u_1.copypet.Mapper.FoodMapper;

public class FoodService {

  private final FoodMapper foodMapper;

  public FoodService(FoodMapper foodMapper) {
    this.foodMapper = foodMapper;
  }

  public Food createFood(Food food) {
    foodMapper.insertFood(food);
    return food;
  }
}
