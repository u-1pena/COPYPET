package com.u_1.copypet.Service;

import com.u_1.copypet.Controller.Response.UserNotFoundException;
import com.u_1.copypet.Entity.User;
import com.u_1.copypet.Mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserMapper userMapper;

  public UserService(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  //ユーザー新規登録
  public User createUser(User user) {
    userMapper.createUser(user);
    return user;
  }

  //ユーザーをidで検索
  public User findById(int id) {
    return this.userMapper.findById(id)
        .orElseThrow(() -> new UserNotFoundException("user not found with id: " + id));

  }

}
