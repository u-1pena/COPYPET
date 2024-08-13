package com.u_1.copypet.Entity;

import com.u_1.copypet.Entity.Enum.ActivityLevel;
import com.u_1.copypet.Entity.Enum.Gender;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.util.Objects;
import lombok.Data;

@Data
public class User {

  @NotBlank
  private int id;
  @NotBlank
  private String name;
  @Min(value = 18, message = "年齢は18歳以上で入力して下さい。")
  @Max(value = 90, message = "年齢は90歳以下で入力して下さい。")
  private int age;
  @Pattern(regexp = "MALE|FEMALE", message = "性別はMALE,FEMALEのどちらかで入力して下さい。")
  private Gender gender;

  @DecimalMin(value = "130.0", message = "身長は「130.0 cm」以上で入力して下さい。")
  @DecimalMax(value = "200.0", message = "身長は「200.0 cm」以下で入力して下さい。")
  private Double height;

  @DecimalMin(value = "40.0", message = "体重は「40.0 kg」以上で入力して下さい。")
  @DecimalMax(value = "120.0", message = "体重は「120.0 kg」以下で入力して下さい。")
  private Double weight;

  @Pattern(regexp = "LOW|MEDIUM|HIGH", message = "活動レベルはLOW,MEDIUM,HIGHのいずれかで選択して下さい。")
  private ActivityLevel activityLevel;


  public User(int id, String name, int age, Gender gender, double height, double weight,
      ActivityLevel activityLevel) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.height = height;
    this.weight = weight;
    this.activityLevel = activityLevel;
  }

  public User(String name, int age, Gender gender, double height, double weight,
      ActivityLevel activityLevel) {

    this.name = name;
    this.age = age;
    this.gender = gender;
    this.height = height;
    this.weight = weight;
    this.activityLevel = activityLevel;
  }


  @Override //別のインスタンスだったとしても同じものと扱うメソットequal
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id) &&
        Objects.equals(name, user.name) &&
        Objects.equals(age, user.age) &&
        Objects.equals(gender, user.gender) &&
        Objects.equals(height, user.height) &&
        Objects.equals(weight, user.weight) &&
        Objects.equals(activityLevel, user.activityLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, age, gender, height, weight, activityLevel);
  }

}

