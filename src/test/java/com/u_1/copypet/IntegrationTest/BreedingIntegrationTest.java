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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DBRider
public class BreedingIntegrationTest {

  @Autowired
  MockMvc mockMvc;

  @Nested
  class CreateClass {

    @Test
    @DataSet(value = {"datasets/breeding.yml", "datasets/insertPets.yml"})
    @ExpectedDataSet(value = "datasets/insertBreeding.yml", ignoreCols = "breeding_date")
    @Transactional
    void 新規に育成データを記録すること() throws Exception {
      String requestBody = """
          {
              "dailyKcal": 220,
              "dailyProtein": 1.5,
              "dailyFat": 0.0,
              "dailyCarbohydrate": 0.0,
              "dailyExercise": 0,
              "dailySleep": 0.0
          }
          """;
      mockMvc.perform(MockMvcRequestBuilders.post("/breeding/3")
              .contentType("application/json")
              .content(requestBody))
          .andExpect(MockMvcResultMatchers.status().isCreated())
          .andExpect(MockMvcResultMatchers.content().json(
              """
                  {
                        "message": "breeding created"
                  }
                  """
          ));
    }

    @Test
    @DataSet(value = "datasets/breeding.yml")
    @Transactional
    void ペット登録されていないIDを指定して育成データを登録しようとするとエラーをかえすこと() throws Exception {
      String requestBody = """
          {
              "dailyKcal": 220,
              "dailyProtein": 1.5,
              "dailyFat": 0.0,
              "dailyCarbohydrate": 0.0,
              "dailyExercise": 0,
              "dailySleep": 0.0
          }
          """;
      mockMvc.perform(MockMvcRequestBuilders.post("/breeding/0")
              .contentType("application/json")
              .content(requestBody))
          .andExpect(MockMvcResultMatchers.status().isNotFound())
          .andExpect(MockMvcResultMatchers.content().json(
              """
                  {
                    "message": "Pet not found with pet id: 0"
                  }
                  """
          ));
    }

    @Test
    @DataSet(value = {"datasets/breeding.yml", "datasets/insertPets.yml"})
    void 既に育成データが登録されているIDで登録しようとするとエラーを返すこと() throws Exception {
      String requestBody = """
          {
              "dailyKcal": 220,
              "dailyProtein": 1.5,
              "dailyFat": 0.0,
              "dailyCarbohydrate": 0.0,
              "dailyExercise": 0,
              "dailySleep": 0.0
          }
          """;
      mockMvc.perform(MockMvcRequestBuilders.post("/breeding/1")
              .contentType("application/json")
              .content(requestBody))
          .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity())
          .andExpect(MockMvcResultMatchers.content().json(
              """
                  {
                    "message": "Breeding already exists with id: 1"
                  }
                  """
          ));
    }

    @Test
    @DataSet(value = "datasets/breeding.yml")
    @Transactional
    void リクエストボディに何も入れなかった場合Validationエラーが発生すること() throws Exception {
      String requestBody = """
          {
              "dailyKcal": "",
              "dailyProtein": "",
              "dailyFat": "",
              "dailyCarbohydrate": "",
              "dailyExercise": "",
              "dailySleep": ""
          }
          """;
      mockMvc.perform(MockMvcRequestBuilders.post("/breeding/1")
              .contentType("application/json")
              .content(requestBody))
          .andExpect(MockMvcResultMatchers.status().isBadRequest())
          .andExpect(MockMvcResultMatchers.content().json(
              """
                  {
                      "status": "BAD_REQUEST",
                      "message": "validation error",
                      "errors": [
                          {
                              "message": "At least one field must be completed, and if nutrients are entered, calories are also required",
                              "entity": "breedingCreateRequest"
                          }
                      ]
                  }
                  """
          ));
    }

    @Test
    @DataSet(value = "datasets/breeding.yml")
    @Transactional
    void 栄養素が入力されているがdailyKcalが0の場合Validationエラーが発生すること() throws Exception {
      String requestBody = """
          {
              "dailyKcal": 0,
              "dailyProtein": "15.5",
              "dailyFat": "",
              "dailyCarbohydrate": "",
              "dailyExercise": "",
              "dailySleep": ""
          }
          """;
      mockMvc.perform(MockMvcRequestBuilders.post("/breeding/3")
              .contentType("application/json")
              .content(requestBody))
          .andExpect(MockMvcResultMatchers.status().isBadRequest())
          .andExpect(MockMvcResultMatchers.content().json(
              """
                  {
                      "status": "BAD_REQUEST",
                      "message": "validation error",
                      "errors": [
                          {
                              "message": "At least one field must be completed, and if nutrients are entered, calories are also required",
                              "entity": "breedingCreateRequest"
                          }
                      ]
                  }
                  """
          ));
    }
  }
}
