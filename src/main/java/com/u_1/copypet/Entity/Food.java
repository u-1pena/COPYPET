package com.u_1.copypet.Entity;

import lombok.Data;

@Data
public class Food {

  private int foodId;
  private String foodName;
  private int foodCalories;
  private double foodProtein;
  private double foodFat;
  private double foodCarbohydrates;

  public Food(int foodId, String foodName, int foodCalories, double foodProtein, double foodFat,
      double foodCarbohydrates) {
    this.foodId = foodId;
    this.foodName = foodName;
    this.foodCalories = foodCalories;
    this.foodProtein = foodProtein;
    this.foodFat = foodFat;
    this.foodCarbohydrates = foodCarbohydrates;
  }

  public Food(String foodName, int foodCalories, double foodProtein, double foodFat,
      double foodCarbohydrates) {
    this.foodName = foodName;
    this.foodCalories = foodCalories;
    this.foodProtein = foodProtein;
    this.foodFat = foodFat;
    this.foodCarbohydrates = foodCarbohydrates;
  }
}
