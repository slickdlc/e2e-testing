package com.tecra.user.application.service;

import java.util.List;
import java.util.function.Consumer;

import com.tecra.user.domain.entity.User;
import com.tecra.user.domain.exception.ServiceException;
import com.tecra.user.domain.repository.UserRepository;
import com.tecra.user.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public void createUser(final User user) {
    if (user.getUserId() != null) {
      throw new IllegalArgumentException("El id debe ser nulo en la creación de un usuario nuevo");
    }
    this.saveUser(user);
  }

  @Override
  public void updateUser(final User user) {
    this.doIfExists(user.getUserId(), userFound -> this.saveUser(user));
  }

  @Override
  public void patchUser(final User user) {
    this.doIfExists(user.getUserId(),
        userFound ->
        {
          if (user.getPassword() != null) {
            userFound.setPassword(user.getPassword());
          }
          if (user.getName() != null) {
            userFound.setName(user.getName());
          }
          if (user.getGender() != null) {
            userFound.setGender(user.getGender());
          }
          if (user.getAge() != null) {
            userFound.setAge(user.getAge());
          }
          if (user.getIdentification() != null) {
            userFound.setIdentification(user.getIdentification());
          }
          if (user.getAddress() != null) {
            userFound.setAddress(user.getAddress());
          }
          if (user.getPhone() != null) {
            userFound.setPhone(user.getPhone());
          }
          this.saveUser(userFound);
        });
  }

  @Override
  public void deleteUser(final Integer userId) {
    this.doIfExists(userId, userFound -> this.userRepository.deleteUserById(userId));
  }

  public void doIfExists(final Integer userId, final Consumer<User> consumerUser) {
    this.userRepository.findUserById(userId)
        .ifPresentOrElse(
            consumerUser,
            () -> {
              throw new ServiceException(HttpStatus.NOT_FOUND, String.format("El usuario con id [%s] no se ha encontrado", userId));
            });
  }

  @Override
  public List<User> getAllUsers() {
    return this.userRepository.readUsers();
  }

  @Override
  public User getUserById(final Integer userId) {
    return this.userRepository.findUserById(userId)
        .orElseThrow(
            () -> new ServiceException(HttpStatus.NOT_FOUND, String.format("El usuario con id [%s] no se ha encontrado", userId)));
  }

  @Override
  public User getUserByIdentification(String identification) {
    return this.userRepository.findUserByIdentification(identification)
        .orElseThrow(
            () -> new ServiceException(HttpStatus.NOT_FOUND,
                String.format("El usuario con identificacion [%s] no se ha encontrado", identification)));
  }

  private void saveUser(final User user) {
    this.validateToSave(user);
    this.userRepository.saveUser(user);
  }

  private void validateToSave(final User user) {
    this.userRepository.findUserByIdentification(user.getIdentification())
        .filter(userFound -> !userFound.getUserId().equals(user.getUserId()))
        .ifPresent(c -> {
          throw new ServiceException(HttpStatus.BAD_REQUEST,
              String.format("El usuario con identificacion [%s] ya existe", c.getIdentification()));
        });
  }

}
