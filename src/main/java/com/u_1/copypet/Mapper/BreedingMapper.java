package com.u_1.copypet.Mapper;

import com.u_1.copypet.Entity.Breeding;
import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BreedingMapper {

  @Insert("INSERT INTO breeding (id, in_take_calories_today, in_take_protein_today, in_take_fat_today, in_take_carbohydrates_today, exercise_to_burn_calories_today, sleeping_time_today, breeding_date) VALUES (#{id}, #{inTakeCaloriesToday}, #{inTakeProteinToday}, #{inTakeFatToday}, #{inTakeCarbohydratesToday}, #{exerciseToBurnCaloriesToday}, #{sleepTimeToday}, #{breedingDate})")
  void insertBreeding(Breeding breeding);

  @Select("SELECT * FROM breeding WHERE id = #{id}")
  Optional<Breeding> findBreedingById(int id);

}
