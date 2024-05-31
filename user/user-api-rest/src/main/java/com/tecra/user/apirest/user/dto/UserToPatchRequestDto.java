package com.tecra.user.apirest.user.dto;

import com.tecra.user.apirest.common.validator.ValidUserGender;
import com.tecra.user.apirest.user.constants.UserValidationMessageConstants;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserToPatchRequestDto {

  @Size(min = 1, max = 50, message = UserValidationMessageConstants.NAME_LENGTH_MESSAGE)
  private String nombre;

  @ValidUserGender(anyOf = {UserGenderEnumDto.FEMALE, UserGenderEnumDto.MALE}, message = UserValidationMessageConstants.GENDER_IS_REQUIRED_MESSAGE)
  private String genero;

  @Min(value = 1, message = UserValidationMessageConstants.AGE_MIN_MESSAGE)
  @Max(value = 100, message = UserValidationMessageConstants.AGE_MAX_MESSAGE)
  private Integer edad;

  @Size(min = 8, max = 8, message = UserValidationMessageConstants.IDENTIFICATION_LENGTH_MESSAGE)
  private String identificacion;

  @Size(min = 1, max = 50, message = UserValidationMessageConstants.ADDRESS_LENGTH_MESSAGE)
  private String direccion;

  @Size(min = 9, max = 9, message = UserValidationMessageConstants.PHONE_LENGTH_MESSAGE)
  private String telefono;

  @Size(min = 8, max = 40, message = UserValidationMessageConstants.PASSWORD_LENGTH_MESSAGE)
  private String contrasena;
}
