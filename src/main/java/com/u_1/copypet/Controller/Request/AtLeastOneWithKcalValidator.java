package com.u_1.copypet.Controller.Request;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AtLeastOneWithKcalValidator implements
    ConstraintValidator<AtLeastOneWithKcal, BreedingCreateRequest> {

  @Override
  public boolean isValid(BreedingCreateRequest breedingCreateRequest,
      ConstraintValidatorContext context) {

    boolean isAnyFieldEntered = breedingCreateRequest.getDailyKcal() != null ||
        breedingCreateRequest.getDailyProtein() != null ||
        breedingCreateRequest.getDailyFat() != null ||
        breedingCreateRequest.getDailyCarbohydrate() != null ||
        breedingCreateRequest.getDailyExercise() != null ||
        breedingCreateRequest.getDailySleep() != null;

    boolean isKcalValid = !(breedingCreateRequest.getDailyProtein() != null ||
        breedingCreateRequest.getDailyFat() != null ||
        breedingCreateRequest.getDailyCarbohydrate() != null) ||
        (breedingCreateRequest.getDailyKcal() != null && breedingCreateRequest.getDailyKcal() > 0);

    return isAnyFieldEntered && isKcalValid;
  }
}
