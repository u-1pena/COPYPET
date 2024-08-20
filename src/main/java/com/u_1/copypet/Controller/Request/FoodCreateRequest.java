package com.u_1.copypet.Controller.Request;

import com.u_1.copypet.Entity.Food;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FoodCreateRequest {

  @NotBlank(message = "食品名を入力してください")
  private String foodName;
  private int foodCalories;
  private double foodProtein;
  private double foodFat;
  private double foodCarbohydrates;

  public FoodCreateRequest() {
    this.foodName = "";
    this.foodCalories = 0;
    this.foodProtein = 0.0;
    this.foodFat = 0.0;
    this.foodCarbohydrates = 0.0;
  }

  public FoodCreateRequest(String foodName, int foodCalories, double foodProtein, double foodFat,
      double foodCarbohydrates) {
    this.foodName = foodName;
    this.foodCalories = foodCalories;
    this.foodProtein = foodProtein;
    this.foodFat = foodFat;
    this.foodCarbohydrates = foodCarbohydrates;
  }

  public Food convertToEntity() {
    return new Food(foodName, foodCalories, foodProtein, foodFat, foodCarbohydrates);
  }
}
