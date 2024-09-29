package com.u_1.copypet.Controller.Request;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AtLeastOneWithKcalValidator.class)
public @interface AtLeastOneWithKcal {

  String message() default "At least one field must be completed, and if nutrients are entered, calories are also required";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};


}
