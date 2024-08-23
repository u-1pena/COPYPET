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

public class PetIntegrationTest {

  @Autowired
  MockMvc mockMvc;

  @Nested
  class CreateClass {

    @Test
    @DataSet(value = {"datasets/insertUsers.yml", "datasets/pets.yml"})
    @ExpectedDataSet(value = "datasets/insertPets.yml")
    @Transactional
    void 紐づけられていないユーザーにペットを登録すること() throws Exception {

      String requestBody = """
          {
              "petName": "testPet"
          }
          """;
      mockMvc.perform(MockMvcRequestBuilders.post("/pets/3")
              .contentType(MediaType.APPLICATION_JSON)
              .content(requestBody))
          .andExpect(MockMvcResultMatchers.status().isCreated())
          .andExpect(MockMvcResultMatchers.content().json(
              """
                  {
                    "message": "The pet registration has been completed. The owner is testUser"
                  }
                  """
          ));
    }

    @Test
    @DataSet(value = {"datasets/users.yml", "datasets/pets.yml"})
    @Transactional
    void ペットを登録されているユーザーを検索した場合重複エラーとなること() throws Exception {
      String requestBody = """
          {
              "petName": "testPet"
          }
          """;
      mockMvc.perform(MockMvcRequestBuilders.post("/pets/1")
              .contentType(MediaType.APPLICATION_JSON)
              .content(requestBody))
          .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity())
          .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("Unprocessable Entity"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.path").value("/pets/1"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.message")
              .value("Pet already exists with user id: 1"));
    }

    @Test
    @DataSet(value = {"datasets/users.yml", "datasets/pets.yml"})
    @Transactional
    void 登録されていないユーザーIDでペット登録をすると失敗すること() throws Exception {
      String requestBody = """
          {
              "petName": "testPet"
          }
          """;
      mockMvc.perform(MockMvcRequestBuilders.post("/pets/3")
              .contentType(MediaType.APPLICATION_JSON)
              .content(requestBody))
          .andExpect(MockMvcResultMatchers.status().isNotFound())
          .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("Not Found"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.path").value("/pets/3"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.message")
              .value("user not found with id: 3"));
    }
  }
}
