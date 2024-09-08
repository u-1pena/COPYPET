package com.u_1.copypet.Controller.Request;

import com.u_1.copypet.Entity.Breeding;
import com.u_1.copypet.Service.BreedingService;
import java.time.LocalDate;
import lombok.Data;

@Data
public class BreedingCreateRequest {

  private int id;
  private int inTakeCaloriesToday;//今日の摂取カロリー
  private double inTakeProteinToday;//今日のタンパク質摂取量
  private double inTakeFatToday;//今日の脂肪摂取量
  private double inTakeCarbohydratesToday;//今日の炭水化物量
  private int exerciseToBurnCaloriesToday;//消費カロリー
  private double sleepTimeToday;//睡眠時間
  private LocalDate breedingDate;//日付

  public BreedingCreateRequest() {

    this.inTakeCaloriesToday = 0;
    this.inTakeProteinToday = 0.0;
    this.inTakeFatToday = 0.0;
    this.inTakeCarbohydratesToday = 0.0;
    this.exerciseToBurnCaloriesToday = 0;
    this.sleepTimeToday = 0.0;
    this.breedingDate = LocalDate.now();
  }

  public BreedingCreateRequest(int id, int inTakeCaloriesToday, double inTakeProteinToday,
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

  public Breeding convertToEntity(BreedingService breedingService) {
    return new Breeding(id, inTakeCaloriesToday, inTakeProteinToday, inTakeFatToday,
        inTakeCarbohydratesToday, exerciseToBurnCaloriesToday, sleepTimeToday, breedingDate);
  }

}
