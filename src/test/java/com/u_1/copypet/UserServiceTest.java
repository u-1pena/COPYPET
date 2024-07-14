package com.u_1.copypet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import com.u_1.copypet.Entity.Enum.ActivityLevel;
import com.u_1.copypet.Entity.Enum.Gender;
import com.u_1.copypet.Entity.User;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

  @InjectMocks
  UserService userService;

  @Mock
  UserMapper userMapper;

  @Nested
  class Create {


    @Test
    void ユーザーを新規登録すること() {
      User user = new User("yuichi", 39, Gender.MALE, 165.5, 65.0, ActivityLevel.MEDIUM);
      doNothing().when(userMapper).insert(user);
      assertThat(userService.userInsert(user)).isEqualTo(user);
      verify(userMapper).insert(user);
    }
  }

}
