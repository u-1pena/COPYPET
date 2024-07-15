package com.u_1.copypet;

import com.u_1.copypet.Entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserMapper userMapper;

  public UserService(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  public User userInsert(User user) {
    userMapper.insert(user);
    return user;
  }

}
