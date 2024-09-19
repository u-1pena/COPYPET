package com.u_1.copypet.Entity;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Breeding {

  private int id;
  private int dailyKcal;//今日の摂取カロリー
  private double dailyProtein;//今日のタンパク質摂取量
  private double dailyFat;//今日の脂肪摂取量
  private double dailyCarbohydrate;//今日の炭水化物量
  private int dailyExercise;//消費カロリー
  private double dailySleep;//睡眠時間
  private LocalDate breedingDate;//日付

  public Breeding(int id, int dailyKcal, double dailyProtein, double dailyFat,
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

  public Breeding(int dailyKcal, double dailyProtein, double dailyFat,
      double dailyCarbohydrate, int dailyExercise, double dailySleep, LocalDate breedingDate) {
    this.dailyKcal = dailyKcal;
    this.dailyProtein = dailyProtein;
    this.dailyFat = dailyFat;
    this.dailyCarbohydrate = dailyCarbohydrate;
    this.dailyExercise = dailyExercise;
    this.dailySleep = dailySleep;
    this.breedingDate = breedingDate;
  }
}
