package com.u_1.copypet.Entity;

import lombok.Data;

@Data
public class Food {

  private int foodId;
  private String foodName;
  private int foodCalorie;
  private double foodProtein;
  private double foodFat;
  private double foodCarbohydrates;

  public Food(int foodId, String foodName, int foodCalorie, double foodProtein, double foodFat,
      double foodCarbohydrates) {
    this.foodId = foodId;
    this.foodName = foodName;
    this.foodCalorie = foodCalorie;
    this.foodProtein = foodProtein;
    this.foodFat = foodFat;
    this.foodCarbohydrates = foodCarbohydrates;
  }

}
