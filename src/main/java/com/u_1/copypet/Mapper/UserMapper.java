package com.u_1.copypet.Mapper;

import com.u_1.copypet.Entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface UserMapper {

  @Insert("INSERT INTO users (name, age, gender, height, weight, activityLevel)VALUES (#{name}, #{age}, #{gender}, #{height}, #{weight}, #{activityLevel})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insert(User user);

}
