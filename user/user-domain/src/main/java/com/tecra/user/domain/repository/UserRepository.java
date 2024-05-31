package com.tecra.user.domain.repository;

import java.util.List;
import java.util.Optional;

import com.tecra.user.domain.entity.User;

public interface UserRepository {

  void saveUser(final User user);

  void deleteUserById(final Integer userId);

  List<User> readUsers();

  Optional<User> findUserById(final Integer userId);

  Optional<User> findUserByIdentification(final String identification);
}
