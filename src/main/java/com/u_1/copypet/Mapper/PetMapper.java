package com.u_1.copypet.Mapper;

import com.u_1.copypet.Entity.Pet;
import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PetMapper {

  @Insert("INSERT INTO pets (user_id, pet_name, age_in_days, pet_gender, bmr, daily_energy_requirement, in_take_calories_today, calorie_expenditure_today, sleep_time, in_take_protein_today, in_take_fat_today, in_take_carbohydrates_today, pet_level) VALUES (#{userId}, #{petName}, #{ageInDays}, #{petGender}, #{bmr}, #{dailyEnergyRequirement}, #{inTakeCaloriesToday}, #{calorieExpenditureToday}, #{sleepTime}, #{inTakeProteinToday}, #{inTakeFatToday}, #{inTakeCarbohydratesToday}, #{petLevel})")
  void insertPet(Pet pet);


  //PetのuserIdを元にPetを取得する。既に登録されているペットを取得する処理
  @Select("SELECT * FROM pets WHERE user_id = #{userId}")
  Optional<Pet> findPetByUserId(int userId);
}
