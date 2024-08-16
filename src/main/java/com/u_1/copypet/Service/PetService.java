package com.u_1.copypet.Service;

import com.u_1.copypet.Controller.Response.PetAlreadyExistsException;
import com.u_1.copypet.Entity.Enum.ActivityLevel;
import com.u_1.copypet.Entity.Enum.Gender;
import com.u_1.copypet.Entity.Pet;
import com.u_1.copypet.Mapper.PetMapper;
import java.util.Optional;
import org.springframework.stereotype.Service;


@Service
public class PetService {

  private final PetMapper petMapper;

  public PetService(PetMapper petMapper) {
    this.petMapper = petMapper;
  }

  public Pet createPet(Pet pet) {
    petMapper.insertPet(pet);
    return pet;
  }

  //修正箇所
  public Optional<Pet> checkPetAlreadyRegisteredByUserId(int userId) {
    return petMapper.checkPetAlreadyRegisteredByUserId(userId)
        .map(pet -> {
          throw new PetAlreadyExistsException("Pet already exists with user id: " + userId);
        });
  }


  // bmrを計算するメソッド
  public double calculateBmr(Gender gender, int age, double height, double weight) {
    if (gender == Gender.MALE) {
      return Math.round((88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age)) * 100)
          / 100.0;
    } else { // Gender.FEMALE
      return Math.round((447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age)) * 100)
          / 100.0;
    }
  }

  // 1日のエネルギー必要量を計算するメソッド
  public double calculateDailyEnergyRequirement(double bmr, ActivityLevel activityLevel) {

    return switch (activityLevel) {
      case LOW -> bmr * 1.2;
      case MEDIUM -> bmr * 1.75;
      case HIGH -> bmr * 2.0;
      default -> 0;
    };
  }

}



