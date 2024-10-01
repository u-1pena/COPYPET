package com.u_1.copypet.MapperTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
import com.u_1.copypet.Entity.Breeding;
import com.u_1.copypet.Mapper.BreedingMapper;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BreedingMapperTest {

  @Autowired
  BreedingMapper breedingMapper;


  @Nested
  class CreateClass {

    @Test
    @DataSet(value = "datasets/breeding.yml")
    @ExpectedDataSet(value = "datasets/insertBreeding.yml", ignoreCols = "id")
    @Transactional
    void 新規に育成データを記録すること() {
      Breeding breeding = new Breeding(3, 220, 1.5, 0.0, 0.0, 0, 0.0,
          LocalDate.of(2022, 1, 3));
      breedingMapper.insertBreeding(breeding);
    }
  }

  @Nested
  class ReadClass {

    @Test
    @DataSet(value = "datasets/breeding.yml")
    @Transactional
    void IDで既に登録されている育成データを検索すること() {
      Optional<Breeding> breeding = breedingMapper.findBreedingById(1);
      assertThat(breeding).contains(new Breeding(1, 1550, 35.0, 35.0, 55.0, 0, 8.0,
          LocalDate.of(2022, 1, 1)));
    }
  }
}
