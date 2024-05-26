package com.devsu.user.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends Person {

  private Integer userId;

  private String password;

  private boolean active;

  @Builder
  public User(final Integer personId, final String name, final String gender,
      final Integer age, final String identification, final String address, final String phone,
      final Integer userId, final String password, final boolean active) {
    super(personId, name, gender, age, identification, address, phone);
    this.userId = userId;
    this.password = password;
    this.active = active;
  }

}
