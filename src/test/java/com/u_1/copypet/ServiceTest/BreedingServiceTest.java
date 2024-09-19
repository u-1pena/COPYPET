package com.u_1.copypet.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import com.u_1.copypet.Controller.Response.BreedingAlreadyExistsException;
import com.u_1.copypet.Entity.Breeding;
import com.u_1.copypet.Mapper.BreedingMapper;
import com.u_1.copypet.Service.BreedingService;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BreedingServiceTest {

  @InjectMocks
  BreedingService breedingService;

  @Mock
  BreedingMapper breedingMapper;

  @Nested
  class Create {

    @Test
    void 新規で育成データを登録する() {
      Breeding breeding = new Breeding(1, 0, 0.0, 0.0, 0.0, 0, 0.0, LocalDate.of(2024, 9, 18));
      doNothing().when(breedingMapper).insertBreeding(breeding);
      assertThat(breedingService.createBreeding(breeding)).isEqualTo(breeding);

    }

    @Test
    void 既に登録されているIDで登録しようとするとエラーを返すこと() {
      doReturn(Optional.of(new Breeding(1, 0, 0.0, 0.0, 0.0, 0, 0.0, LocalDate.of(2024, 9, 18)))
      ).when(breedingMapper).findBreedingById(1);
      assertThatThrownBy(() -> breedingService.findBreedingById(1))
          .isInstanceOf(BreedingAlreadyExistsException.class)
          .hasMessage("Breeding already exists with id: 1");
    }

    @Test
    void ペット登録されていないIDを指定して育成データを登録しようとするとエラーをかえすこと() {
      doReturn(Optional.empty()).when(breedingMapper).findBreedingById(0);
      assertThat(breedingService.findBreedingById(0)).isEmpty();
      verify(breedingMapper).findBreedingById(0);
    }

  }
}
