package com.u_1.copypet.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import com.u_1.copypet.Controller.Response.PetAlreadyExistsException;
import com.u_1.copypet.Entity.Enum.Gender;
import com.u_1.copypet.Entity.Pet;
import com.u_1.copypet.Mapper.PetMapper;
import com.u_1.copypet.Service.PetService;
import java.util.Optional;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PetServiceTest {

  @InjectMocks
  PetService petService;

  @Mock
  PetMapper petMapper;

  @Nested
  class Create {

    @Test
    void ペットを新規登録すること() {
      Pet pet = new Pet(1, "testPet", 0, Gender.MALE, 0, 0, 0, 0, 0, 0, 0, 0, 0);
      doNothing().when(petMapper).insertPet(pet);
      assertThat(petService.createPet(pet)).isEqualTo(pet);
      verify(petMapper).insertPet(pet);
    }


    @Test
    void ペット登録されているユーザーを検索した場合例外処理をかえすこと() {
      doReturn(Optional.of(new Pet(1, "testPet", 0, Gender.MALE, 0, 0, 0, 0, 0, 0, 0, 0, 0)))
          .when(petMapper).findPetByUserId(1);
      assertThatThrownBy(() -> petService.findPetByUserId(1))
          .isInstanceOf(PetAlreadyExistsException.class)
          .hasMessage("Pet already exists with user id: 1");
    }

    @Test
    void ペット登録されていないユーザーを検索すること() {
      doReturn(Optional.empty()).when(petMapper).findPetByUserId(1);
      Pet actual = petService.findPetByUserId(1);
      assertThat(actual).isNull();
      verify(petMapper).findPetByUserId(1);
    }

  }
}
