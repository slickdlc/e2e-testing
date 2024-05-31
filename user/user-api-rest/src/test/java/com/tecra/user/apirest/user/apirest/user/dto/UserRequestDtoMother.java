package com.tecra.user.apirest.user.apirest.user.dto;

import com.tecra.UserMother;
import com.tecra.user.apirest.user.dto.UserRequestDto;
import com.tecra.user.apirest.user.dto.UserRequestDto.UserRequestDtoBuilder;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserRequestDtoMother {

  public UserRequestDtoBuilder builder() {
    return UserRequestDto.builder()
        .nombre(UserMother.NAME)
        .genero(UserMother.GENDER)
        .edad(UserMother.AGE)
        .identificacion(UserMother.IDENTIFICATION)
        .direccion(UserMother.ADDRESS)
        .telefono(UserMother.PHONE)
        .contrasena(UserMother.PASSWORD)
        .activo(UserMother.ACTIVE);
  }

  public UserRequestDto complete() {
    return builder().build();
  }

  public UserRequestDto withName(final String name) {
    return builder()
        .nombre(name)
        .build();
  }

  public static UserRequestDto withAge(final Integer age) {
    return builder()
        .edad(age)
        .build();
  }

  public static UserRequestDto withIdentification(final String identification) {
    return builder()
        .identificacion(identification)
        .build();
  }

  public static UserRequestDto withAddress(final String address) {
    return builder()
        .direccion(address)
        .build();
  }

  public static UserRequestDto withPhone(final String phone) {
    return builder()
        .telefono(phone)
        .build();
  }

  public static UserRequestDto withPassword(final String password) {
    return builder()
        .contrasena(password)
        .build();
  }

  public static UserRequestDto withActive(Boolean active) {
    return builder()
        .activo(active)
        .build();
  }

}
