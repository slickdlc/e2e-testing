package com.devsu.user.apirest.user.dto;

import static com.devsu.user.apirest.user.constants.UserValidationMessageConstants.ACTIVE_MESSAGE;
import static com.devsu.user.apirest.user.constants.UserValidationMessageConstants.ADDRESS_LENGTH_MESSAGE;
import static com.devsu.user.apirest.user.constants.UserValidationMessageConstants.AGE_MAX_MESSAGE;
import static com.devsu.user.apirest.user.constants.UserValidationMessageConstants.AGE_MIN_MESSAGE;
import static com.devsu.user.apirest.user.constants.UserValidationMessageConstants.GENDER_IS_REQUIRED_MESSAGE;
import static com.devsu.user.apirest.user.constants.UserValidationMessageConstants.IDENTIFICATION_LENGTH_MESSAGE;
import static com.devsu.user.apirest.user.constants.UserValidationMessageConstants.NAME_IS_REQUIRED_MESSAGE;
import static com.devsu.user.apirest.user.constants.UserValidationMessageConstants.NAME_LENGTH_MESSAGE;
import static com.devsu.user.apirest.user.constants.UserValidationMessageConstants.PASSWORD_LENGTH_MESSAGE;
import static com.devsu.user.apirest.user.constants.UserValidationMessageConstants.PHONE_LENGTH_MESSAGE;

import com.devsu.user.apirest.common.validator.ValidUserGender;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

  @NotNull(message = NAME_IS_REQUIRED_MESSAGE)
  @Size(min = 1, max = 50, message = NAME_LENGTH_MESSAGE)
  private String nombre;

  @NotNull(message = GENDER_IS_REQUIRED_MESSAGE)
  @ValidUserGender(anyOf = {UserGenderEnumDto.FEMALE, UserGenderEnumDto.MALE}, message = GENDER_IS_REQUIRED_MESSAGE)
  private String genero;

  @NotNull(message = AGE_MIN_MESSAGE)
  @Min(value = 1, message = AGE_MIN_MESSAGE)
  @Max(value = 100, message = AGE_MAX_MESSAGE)
  private Integer edad;

  @NotNull(message = IDENTIFICATION_LENGTH_MESSAGE)
  @Size(min = 8, max = 8, message = IDENTIFICATION_LENGTH_MESSAGE)
  private String identificacion;

  @NotNull(message = ADDRESS_LENGTH_MESSAGE)
  @Size(min = 1, max = 50, message = ADDRESS_LENGTH_MESSAGE)
  private String direccion;

  @NotNull(message = PHONE_LENGTH_MESSAGE)
  @Size(min = 9, max = 9, message = PHONE_LENGTH_MESSAGE)
  private String telefono;

  @NotNull(message = PASSWORD_LENGTH_MESSAGE)
  @Size(min = 8, max = 40, message = PASSWORD_LENGTH_MESSAGE)
  private String contrasena;

  @NotNull(message = ACTIVE_MESSAGE)
  private Boolean activo;
}
