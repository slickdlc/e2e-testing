package com.tecra.user.apirest.common.validator;

import java.util.Arrays;

import com.tecra.user.apirest.user.dto.UserGenderEnumDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserGenderValidator implements ConstraintValidator<ValidUserGender, String> {

  private String[] subset;

  @Override
  public void initialize(ValidUserGender constraint) {
    this.subset = Arrays.stream(constraint.anyOf()).map(UserGenderEnumDto::getValue).toArray(String[]::new);
  }

  @Override
  public boolean isValid(final String value, ConstraintValidatorContext context) {
    return value == null || Arrays.asList(subset).contains(value);
  }
}
