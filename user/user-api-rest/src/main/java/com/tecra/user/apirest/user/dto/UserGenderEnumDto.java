package com.tecra.user.apirest.user.dto;

import lombok.Getter;

@Getter
public enum UserGenderEnumDto {
  FEMALE("F"),
  MALE("M");

  private final String value;

  private UserGenderEnumDto(final String value) {
    this.value = value;
  }

  public static UserGenderEnumDto fromString(final String value) {
    if (value.equalsIgnoreCase("F")) {
      return FEMALE;
    } else if (value.equalsIgnoreCase("M")) {
      return MALE;
    }
    throw new IllegalArgumentException("Invalid value");
  }
}
