package com.tecra;

import com.tecra.user.domain.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMother {

  public static final Integer PERSON_ID = 1;

  public static final String NAME = "John Doe";

  public static final String GENDER = "M";

  public static final Integer AGE = 30;

  public static final String IDENTIFICATION = "12345678";

  public static final String ADDRESS = "123 Main St";

  public static final String PHONE = "123456789";

  public static final Integer USER_ID = 1;

  public static final String PASSWORD = "password";

  public static final boolean ACTIVE = true;

  public static User.UserBuilder builder() {
    return User.builder()
        .personId(PERSON_ID)
        .name(NAME)
        .gender(GENDER)
        .age(AGE)
        .identification(IDENTIFICATION)
        .address(ADDRESS)
        .phone(PHONE)
        .userId(USER_ID)
        .password(PASSWORD)
        .active(ACTIVE);
  }

  public static User complete() {
    return builder().build();
  }

  public static User withUserId(final Integer userId) {
    return builder().userId(userId).build();
  }

}
