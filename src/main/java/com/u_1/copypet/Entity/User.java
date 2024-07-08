package com.u_1.copypet.Entity;

import com.u_1.copypet.Entity.Enum.ActivityLevel;
import com.u_1.copypet.Entity.Enum.Gender;
import java.util.Objects;

public class User {

  private int id;
  private String name;

  private int age;

  private Gender gender;
  private Double height;
  private Double weight;
  private ActivityLevel activityLevel;


  public User(int id, String name, int age, Gender gender, Double height, Double weight,
      ActivityLevel activityLevel) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.height = height;
    this.weight = weight;
    this.activityLevel = activityLevel;
  }

  public User(String name, int age, Gender gender, Double height, Double weight,
      ActivityLevel activityLevel) {

    this.name = name;
    this.age = age;
    this.gender = gender;
    this.height = height;
    this.weight = weight;
    this.activityLevel = activityLevel;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public Gender getGender() {
    return gender;
  }

  public Double getHeight() {
    return height;
  }

  public Double getWeight() {
    return weight;
  }

  public ActivityLevel getActivityLevel() {
    return activityLevel;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public void setActivityLevel(ActivityLevel activityLevel) {
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

