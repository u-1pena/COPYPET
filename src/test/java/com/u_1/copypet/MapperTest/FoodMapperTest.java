package com.u_1.copypet.MapperTest;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
import com.u_1.copypet.Entity.Food;
import com.u_1.copypet.Mapper.FoodMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FoodMapperTest {

  @Autowired
  FoodMapper foodMapper;

  @Test
  @DataSet(value = "datasets/foods.yml")
  @ExpectedDataSet(value = "datasets/insertFoods.yml", ignoreCols = "food_id")
  @Transactional
  void 食べ物を新規で登録できること() {
    Food food = new Food("testFood", 100, 10.0, 10.0, 10.0);
    foodMapper.insertFood(food);
  }


}
