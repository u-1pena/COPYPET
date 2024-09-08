package com.u_1.copypet.Entity;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Breeding {

  private int id;
  private int inTakeCaloriesToday;//今日の摂取カロリー
  private double inTakeProteinToday;//今日のタンパク質摂取量
  private double inTakeFatToday;//今日の脂肪摂取量
  private double inTakeCarbohydratesToday;//今日の炭水化物量
  private int exerciseToBurnCaloriesToday;//消費カロリー
  private double sleepTimeToday;//睡眠時間
  private LocalDate breedingDate;//日付

  public Breeding(int id, int inTakeCaloriesToday, double inTakeProteinToday,
      double inTakeFatToday, double inTakeCarbohydratesToday, int exerciseToBurnCaloriesToday,
      double sleepTimeToday, LocalDate breedingDate) {
    this.id = id;
    this.inTakeCaloriesToday = inTakeCaloriesToday;
    this.inTakeProteinToday = inTakeProteinToday;
    this.inTakeFatToday = inTakeFatToday;
    this.inTakeCarbohydratesToday = inTakeCarbohydratesToday;
    this.exerciseToBurnCaloriesToday = exerciseToBurnCaloriesToday;
    this.sleepTimeToday = sleepTimeToday;
    this.breedingDate = breedingDate;
  }

  public Breeding(int inTakeCaloriesToday, double inTakeProteinToday, double inTakeFatToday,
      double inTakeCarbohydratesToday, int exerciseToBurnCaloriesToday, double sleepTimeToday,
      LocalDate breedingDate) {
    this.inTakeCaloriesToday = inTakeCaloriesToday;
    this.inTakeProteinToday = inTakeProteinToday;
    this.inTakeFatToday = inTakeFatToday;
    this.inTakeCarbohydratesToday = inTakeCarbohydratesToday;
    this.exerciseToBurnCaloriesToday = exerciseToBurnCaloriesToday;
    this.sleepTimeToday = sleepTimeToday;
    this.breedingDate = breedingDate;
  }
}
