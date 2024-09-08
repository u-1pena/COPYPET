package com.u_1.copypet.Entity;

import com.u_1.copypet.Entity.Enum.Gender;
import lombok.Data;

@Data
public class Pet {

  private int id;
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

  public Pet(int id, String petName, int ageInDays, Gender petGender,
      double bmr, double dailyEnergyRequirement,
      double inTakeCaloriesToday, double calorieExpenditureToday,
      double sleepTime, double inTakeProteinToday, double inTakeFatToday,
      double inTakeCarbohydratesToday, int petLevel) {
    this.id = id;
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

  public Pet(String petName, int ageInDays, Gender petGender, double bmr,
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
}
