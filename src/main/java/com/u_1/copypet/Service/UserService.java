package com.u_1.copypet.Service;

import com.u_1.copypet.Entity.User;
import com.u_1.copypet.Mapper.UserMapper;
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
