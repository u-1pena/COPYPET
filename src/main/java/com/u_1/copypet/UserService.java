package com.u_1.copypet;

import com.u_1.copypet.Entity.Enum.ActivityLevel;
import com.u_1.copypet.Entity.Enum.Gender;
import com.u_1.copypet.Entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserMapper userMapper;

  public UserService(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  public User userInsert(String name, int age, Gender gender, Double height, Double weight,
      ActivityLevel activityLevel) {
    User user = new User(name, age, gender, height, weight, activityLevel);

    // UserMapperを使用してユーザー情報をデータベースに挿入する
    userMapper.insert(user);

    return user;
  }
}
