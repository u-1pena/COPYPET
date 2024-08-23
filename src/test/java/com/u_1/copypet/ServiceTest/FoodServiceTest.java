package com.u_1.copypet.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import com.u_1.copypet.Entity.Food;
import com.u_1.copypet.Mapper.FoodMapper;
import com.u_1.copypet.Service.FoodService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class FoodServiceTest {

  @InjectMocks
  FoodService foodService;

  @Mock
  FoodMapper foodMapper;

  @Test
  void 新規に食べ物を登録すること() {
    Food food = new Food("testFood", 100, 14.2, 0.8, 23.5);
    doNothing().when(foodMapper).insertFood(food);
    assertThat(foodService.createFood(food)).isEqualTo(food);
    verify(foodMapper).insertFood(food);
  }

}
