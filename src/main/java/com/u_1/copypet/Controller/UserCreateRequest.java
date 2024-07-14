package com.u_1.copypet.Controller;

import com.u_1.copypet.Entity.Enum.ActivityLevel;
import com.u_1.copypet.Entity.Enum.Gender;
import com.u_1.copypet.Entity.User;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public class UserCreateRequest {

  @NotBlank
  private String name;
  @Min(value = 18, message = "年齢は18歳以上で入力して下さい。")
  @Max(value = 90, message = "年齢は90歳以下で入力して下さい。")
  private int age;
  @Pattern(regexp = "MALE|FEMALE", message = "性別はMALE,FEMALEのどちらかで入力して下さい。")
  private String gender;

  @DecimalMin(value = "130.0", message = "身長は「130.0 cm」以上で入力して下さい。")
  @DecimalMax(value = "200.0", message = "身長は「200.0 cm」以下で入力して下さい。")
  private Double height;

  @DecimalMin(value = "40.0", message = "体重は「40.0 kg」以上で入力して下さい。")
  @DecimalMax(value = "120.0", message = "体重は「120.0 kg」以下で入力して下さい。")
  private Double weight;

  @Pattern(regexp = "LOW|MEDIUM|HIGH", message = "活動レベルはLOW,MEDIUM,HIGHのいずれかで選択して下さい。")
  private String activityLevel;

  //UserRequestのGender,ActivityLevelをStringからEnum型にConvertするmethod
  public User convertToEntity() {
    return new User(name, age, Gender.valueOf(gender.toUpperCase()), height, weight,
        ActivityLevel.valueOf(activityLevel.toUpperCase())
    );
  }

  public UserCreateRequest(String name, int age, String gender, Double height, Double weight,
      String activityLevel) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.height = height;
    this.weight = weight;
    this.activityLevel = activityLevel;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getGender() {
    return gender;
  }

  public Double getHeight() {
    return height;
  }

  public Double getWeight() {
    return weight;
  }

  public String getActivityLevel() {
    return activityLevel;
  }
}
