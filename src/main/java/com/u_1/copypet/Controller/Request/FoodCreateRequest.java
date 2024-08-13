package com.u_1.copypet.Controller.Request;

import com.u_1.copypet.Entity.Food;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FoodCreateRequest {

  @NotBlank(message = "食品名を入力してください")
  private String foodName;
  private int calorie;
  private double protein;
  private double fat;
  private double carbohydrates;

  public FoodCreateRequest() {
    this.foodName = "";
    this.calorie = 0;
    this.protein = 0.0;
    this.fat = 0.0;
    this.carbohydrates = 0.0;
  }

  public FoodCreateRequest(String foodName, int calorie, double protein, double fat,
      double carbohydrates) {
    this.foodName = foodName;
    this.calorie = calorie;
    this.protein = protein;
    this.fat = fat;
    this.carbohydrates = carbohydrates;
  }

  public Food convertToEntity() {
    return new Food(foodName, calorie, protein, fat, carbohydrates);
  }
}
