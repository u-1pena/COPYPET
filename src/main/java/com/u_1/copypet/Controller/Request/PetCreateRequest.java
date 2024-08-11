package com.u_1.copypet.Controller.Request;

import com.u_1.copypet.Entity.Enum.ActivityLevel;
import com.u_1.copypet.Entity.Enum.Gender;
import com.u_1.copypet.Entity.Pet;
import com.u_1.copypet.Entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PetCreateRequest {

  @NotBlank(message = "ペット名を入力してください")
  private String petName;//ペットの名前
  private int ageInDays;//ペットの年齢
  private Gender petGender;//ペットの性別
  private double bmr;//基礎代謝
  private double dailyEnergyRequirement;//bmr*ActivityLevel
  private double inTakeCaloriesToday;//今日の摂取カロリー
  private double calorieExpenditureToday;//消費カロリー
  private double sleepTime;//睡眠時間
  private double inTakeProteinToday;//今日のタンパク質摂取量
  private double inTakeFatToday;//今日の脂肪摂取量
  private double inTakeCarbohydratesToday;//今日の炭水化物量
  private int petLevel;//ペットのレベル

  //default constructor
  public PetCreateRequest() {
    this.petName = "";
    this.ageInDays = 0;
    this.petGender = Gender.MALE;
    this.bmr = 0.0;
    this.dailyEnergyRequirement = 0.0;
    this.inTakeCaloriesToday = 0.0;
    this.calorieExpenditureToday = 0.0;
    this.sleepTime = 0.0;
    this.inTakeProteinToday = 0.0;
    this.inTakeFatToday = 0.0;
    this.inTakeCarbohydratesToday = 0.0;
    this.petLevel = 1;
  }


  public PetCreateRequest(String petName, int ageInDays, Gender petGender, double bmr,
      double dailyEnergyRequirement, double inTakeCaloriesToday, double calorieExpenditureToday,
      double sleepTime, double inTakeProteinToday, double inTakeFatToday,
      double inTakeCarbohydratesToday, int petLevel) {
    this.petName = petName;
    this.ageInDays = ageInDays;
    this.petGender = petGender;
    this.bmr = bmr;
    this.dailyEnergyRequirement = dailyEnergyRequirement;
    this.inTakeCaloriesToday = inTakeCaloriesToday;
    this.calorieExpenditureToday = calorieExpenditureToday;
    this.sleepTime = sleepTime;
    this.inTakeProteinToday = inTakeProteinToday;
    this.inTakeFatToday = inTakeFatToday;
    this.inTakeCarbohydratesToday = inTakeCarbohydratesToday;
    this.petLevel = petLevel;
  }

  public Pet convertToEntity(User user) {
    double bmr = calculateBmr(user.getGender(), user.getAge(), user.getHeight(), user.getWeight());
    double dailyEnergyRequirement = calculateDailyEnergyRequirement(bmr, user.getActivityLevel());

    return new Pet(user.getId(), petName, ageInDays, user.getGender(), bmr, dailyEnergyRequirement,
        inTakeCaloriesToday, calorieExpenditureToday, sleepTime, inTakeProteinToday, inTakeFatToday,
        inTakeCarbohydratesToday, 0);
  }

  //bmr
  public double calculateBmr(Gender gender, int age, double height, double weight) {
    if (gender == Gender.MALE) {
      return Math.round((88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age)) * 100)
          / 100.0;
    } else { // Gender.FEMALE
      return Math.round((447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age)) * 100)
          / 100.0;
    }
  }


  //bmr*ActivityLevel
  public double calculateDailyEnergyRequirement(double bmr, ActivityLevel activityLevel) {

    return switch (activityLevel) {
      case LOW -> bmr * 1.2;
      case MEDIUM -> bmr * 1.75;
      case HIGH -> bmr * 2.0;
      default -> 0;
    };
  }
}
