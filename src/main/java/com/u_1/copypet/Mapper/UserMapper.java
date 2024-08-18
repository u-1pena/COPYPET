package com.u_1.copypet.Mapper;

import com.u_1.copypet.Entity.User;
import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Insert("INSERT INTO users (name, age, gender, height, weight, activity_level) VALUES (#{name}, #{age}, #{gender}, #{height}, #{weight}, #{activityLevel})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insertUser(User user);

  @Results(value = {
      @Result(property = "id", column = "id"),
      @Result(property = "name", column = "name"),
      @Result(property = "age", column = "age"),
      @Result(property = "gender", column = "gender"),
      @Result(property = "height", column = "height"),
      @Result(property = "weight", column = "weight"),
      @Result(property = "activityLevel", column = "activity_level")
  })
  @Select("SELECT * FROM users WHERE id = #{id}")
  Optional<User> findById(int id);
}
