package com.u_1.copypet.Controller.Request;

import com.u_1.copypet.Entity.Breeding;
import com.u_1.copypet.Service.BreedingService;
import java.time.LocalDate;
import lombok.Data;

@Data
public class BreedingCreateRequest {

  private int id;
  private int dailyKcal;//今日の摂取カロリー
  private double dailyProtein;//今日のタンパク質摂取量
  private double dailyFat;//今日の脂肪摂取量
  private double dailyCarbohydrate;//今日の炭水化物量
  private int dailyExercise;//消費カロリー
  private double dailySleep;//睡眠時間
  private LocalDate breedingDate;//日付

  public BreedingCreateRequest() {

    this.dailyKcal = 0;
    this.dailyProtein = 0.0;
    this.dailyFat = 0.0;
    this.dailyCarbohydrate = 0.0;
    this.dailyExercise = 0;
    this.dailySleep = 0.0;
    this.breedingDate = LocalDate.now();
  }

  public BreedingCreateRequest(int id, int dailyKcal, double dailyProtein, double dailyFat,
      double dailyCarbohydrate, int dailyExercise, double dailySleep, LocalDate breedingDate) {
    this.id = id;
    this.dailyKcal = dailyKcal;
    this.dailyProtein = dailyProtein;
    this.dailyFat = dailyFat;
    this.dailyCarbohydrate = dailyCarbohydrate;
    this.dailyExercise = dailyExercise;
    this.dailySleep = dailySleep;
    this.breedingDate = breedingDate;
  }

  public Breeding convertToEntity(BreedingService breedingService) {
    return new Breeding(id, dailyKcal, dailyProtein, dailyFat, dailyCarbohydrate, dailyExercise,
        dailySleep, breedingDate);
  }
}

