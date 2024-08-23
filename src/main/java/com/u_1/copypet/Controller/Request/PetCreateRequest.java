package com.u_1.copypet.Controller.Request;

import com.u_1.copypet.Entity.Enum.Gender;
import com.u_1.copypet.Entity.Pet;
import com.u_1.copypet.Entity.User;
import com.u_1.copypet.Service.PetService;
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

  public Pet convertToEntity(User user, PetService petService) {
    return new Pet(user.getId(), getPetName(), ageInDays, user.getGender(),
        petService.calculateBmr(user.getGender(), user.getAge(), user.getHeight(),
            user.getWeight()),
        petService.calculateDailyEnergyRequirement(
            petService.calculateBmr(user.getGender(), user.getAge(), user.getHeight(),
                user.getWeight()), user.getActivityLevel()),
        inTakeCaloriesToday, calorieExpenditureToday, sleepTime, inTakeProteinToday, inTakeFatToday,
        inTakeCarbohydratesToday, petLevel);
  }
}

