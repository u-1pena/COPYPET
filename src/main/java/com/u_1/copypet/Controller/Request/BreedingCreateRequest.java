package com.u_1.copypet.Controller.Request;

import com.u_1.copypet.Entity.Breeding;
import com.u_1.copypet.Entity.Pet;
import java.time.LocalDate;
import lombok.Data;
import org.springframework.validation.annotation.Validated;


@Data
@Validated
@AtLeastOneWithKcal//最低限1つの値が入力されていてPFCのいずれかが入力されている場合は0kcalを許容しない
public class BreedingCreateRequest {

  private Integer dailyKcal;//今日の摂取カロリー
  private Double dailyProtein;//今日のタンパク質摂取量
  private Double dailyFat;//今日の脂肪摂取量
  private Double dailyCarbohydrate;//今日の炭水化物量
  private Integer dailyExercise;//消費カロリー
  private Double dailySleep;//睡眠時間
  private LocalDate breedingDate;//日付

  public BreedingCreateRequest() {

  }

  public BreedingCreateRequest(int dailyKcal, double dailyProtein, double dailyFat,
      double dailyCarbohydrate, int dailyExercise, double dailySleep, LocalDate breedingDate) {

    this.dailyKcal = dailyKcal;
    this.dailyProtein = dailyProtein;
    this.dailyFat = dailyFat;
    this.dailyCarbohydrate = dailyCarbohydrate;
    this.dailyExercise = dailyExercise;
    this.dailySleep = dailySleep;
    this.breedingDate = breedingDate;
  }

  public Breeding convertToEntity(Pet pet) {
    return new Breeding(pet.getId(),
        dailyKcal != null ? dailyKcal : 0,
        dailyProtein != null ? dailyProtein : 0.0,
        dailyFat != null ? dailyFat : 0.0,
        dailyCarbohydrate != null ? dailyCarbohydrate : 0.0,
        dailyExercise != null ? dailyExercise : 0,
        dailySleep != null ? dailySleep : 0.0,
        breedingDate != null ? breedingDate : LocalDate.now());
  }
}

