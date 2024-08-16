package com.u_1.copypet.MapperTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
import com.u_1.copypet.Entity.Enum.Gender;
import com.u_1.copypet.Entity.Pet;
import com.u_1.copypet.Mapper.PetMapper;
import java.util.Optional;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;


@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PetMapperTest {

  @Autowired
  PetMapper petMapper;

  @Nested
  class CreateClass {

    @Test
    @DataSet(value = "datasets/pets.yml")
    @ExpectedDataSet(value = "datasets/insertPets.yml", ignoreCols = "id")
    @Sql(statements = "SET FOREIGN_KEY_CHECKS = 0", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "SET FOREIGN_KEY_CHECKS = 1", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Transactional
    void ペットを新規で登録できること() {
      Pet pet = new Pet(3, "testPet", 0, Gender.MALE, 1748.87, 3497.74, 0, 0, 0, 0, 0, 0, 1);
      petMapper.insertPet(pet);
    }
  }

  @Nested
  class ReadClass {

    @Test
    @DataSet(value = "datasets/pets.yml")
    @Transactional
    void ユーザーIDで既にユーザーと紐づけされているペットを検索すること() {
      Optional<Pet> pet = petMapper.checkPetAlreadyRegisteredByUserId(1);
      assertThat(pet).contains(new Pet(1, "ganmo", 0, Gender.MALE, 0, 0, 0, 0, 0, 0, 0, 0, 0));

    }
  }
}
