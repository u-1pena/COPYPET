package com.u_1.copypet.Mapper;

import com.u_1.copypet.Entity.Breeding;
import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BreedingMapper {

  @Insert("INSERT INTO breeding (id, daily_kcal, daily_protein, daily_fat, daily_carbohydrate, daily_exercise, daily_sleep, breeding_date) VALUES (#{id}, #{dailyKcal}, #{dailyProtein}, #{dailyFat}, #{dailyCarbohydrate}, #{dailyExercise}, #{dailySleep}, #{breedingDate})")
  void insertBreeding(Breeding breeding);

  @Select("SELECT * FROM breeding WHERE id = #{id}")
  Optional<Breeding> findBreedingById(int id);

}
