package com.u_1.copypet.Entity;

import com.u_1.copypet.Entity.Enum.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Pet {

  @Setter
  @Getter
  private int id;
  private String petName;
  private Gender petGender;
  private Double bmr;
  private Double dailyEnergyRequirement;
  private Double dailyCaloriesConsumed;
  private Double dailyCaloriesBurned;
  private Double sleepTime;
  private Double protein;
  private Double fat;
  private Double carbohydrates;
  private int petLevel;

  public Pet(int id, String petName, Gender petGender, Double bmr, Double dailyEnergyRequirement,
      Double dailyCaloriesConsumed, Double dailyCaloriesBurned, Double sleepTime, Double protein,
      Double fat, Double carbohydrates, int petLevel) {
    this.id = id;
    this.petName = petName;
    this.petGender = petGender;
    this.bmr = bmr;
    this.dailyEnergyRequirement = dailyEnergyRequirement;
    this.dailyCaloriesConsumed = dailyCaloriesConsumed;
    this.dailyCaloriesBurned = dailyCaloriesBurned;
    this.sleepTime = sleepTime;
    this.protein = protein;
    this.fat = fat;
    this.carbohydrates = carbohydrates;
    this.petLevel = petLevel;
  }

}
