package com.u_1.copypet.IntegrationTest;


import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DBRider
public class FoodIntegrationTest {

  @Autowired
  MockMvc mockMvc;

  @Nested
  class CreateClass {

    @Test
    @DataSet(value = "datasets/foods.yml")
    @ExpectedDataSet(value = "datasets/insertFoods.yml", ignoreCols = "food_id")
    @Transactional
    void 食べ物を新規で登録すること() throws Exception {

      String requestBody = """
          {
              "foodName": "testFood",
              "foodCalories": 100,
              "foodProtein": 10.0,
              "foodFat": 10.0,
              "foodCarbohydrates": 10.0
          }
          """;

      mockMvc.perform(MockMvcRequestBuilders.post("/foods")
              .contentType(MediaType.APPLICATION_JSON)
              .content(requestBody))
          .andExpect(MockMvcResultMatchers.status().isCreated())
          .andExpect(MockMvcResultMatchers.content().json(
              """
                  {
                    "message": "food created"
                  }
                  """
          ));

    }

    @Test
    @DataSet(value = "datasets/foods.yml")
    @Transactional
    void 食品名を入力せずに食品を登録するとエラーが発生すること() throws Exception {

      String requestBody = """
          {
              "foodCalories": 100,
              "foodProtein": 10.0,
              "foodFat": 10.0,
              "foodCarbohydrates": 10.0
          }
          """;

      mockMvc.perform(MockMvcRequestBuilders.post("/foods")
              .contentType(MediaType.APPLICATION_JSON)
              .content(requestBody))
          .andExpect(MockMvcResultMatchers.status().isBadRequest())
          .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("validation error"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.errors[0].field").value("foodName"))
          .andExpect(
              MockMvcResultMatchers.jsonPath("$.errors[0].message").value("食品名を入力してください"));
    }


  }


}
