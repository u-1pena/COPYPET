package com.u_1.copypet.MapperTest;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
import com.u_1.copypet.Entity.Enum.ActivityLevel;
import com.u_1.copypet.Entity.Enum.Gender;
import com.u_1.copypet.Entity.User;
import com.u_1.copypet.Mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class UserMapperTest {

  @Autowired
  UserMapper userMapper;

  @Test
  @DataSet(value = "datasets/users.yml")
  @ExpectedDataSet(value = "datasets/insertUsers.yml", ignoreCols = "id")
  //外部キーのリセットを追加
  @Sql(statements = "SET FOREIGN_KEY_CHECKS = 0", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
  @Sql(statements = "SET FOREIGN_KEY_CHECKS = 1", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
  @Transactional
  void ユーザーを新規で登録できること() {
    User user = new User("testUser", 40, Gender.MALE, 170.0, 80.0, ActivityLevel.HIGH);
    userMapper.createUser(user);
  }
}
