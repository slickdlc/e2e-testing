package com.tecra.user.infrastructure.entity;

import com.tecra.UserMother;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserEntityMother {

  public UserEntity.UserEntityBuilder builder() {
    return UserEntity.builder()
        .name(UserMother.NAME)
        .gender(UserMother.GENDER)
        .age(UserMother.AGE)
        .identification(UserMother.IDENTIFICATION)
        .address(UserMother.ADDRESS)
        .phone(UserMother.PHONE)
        .password(UserMother.PASSWORD)
        .active(UserMother.ACTIVE);
  }

  public UserEntity complete() {
    return builder().build();
  }
}
