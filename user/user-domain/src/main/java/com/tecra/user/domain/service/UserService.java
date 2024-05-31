package com.tecra.user.domain.service;

import java.util.List;

import com.tecra.user.domain.entity.User;

public interface UserService {

  void createUser(final User user);

  void updateUser(final User user);

  void patchUser(final User user);

  void deleteUser(final Integer userId);

  List<User> getAllUsers();

  User getUserById(final Integer userId);

  User getUserByIdentification(final String identification);
}
