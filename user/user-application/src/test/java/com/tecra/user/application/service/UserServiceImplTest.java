package com.tecra.user.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import com.tecra.UserMother;
import com.tecra.user.domain.exception.ServiceException;
import com.tecra.user.domain.repository.UserRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

  @InjectMocks
  private UserServiceImpl userService;

  @Mock
  private UserRepository userRepository;

  @Nested
  class CreateUser {

    @Test
    void given_userWithId_when_createUser_then_expectedException() {
      final var user = UserMother.complete();

      assertThrows(IllegalArgumentException.class, () -> UserServiceImplTest.this.userService.createUser(user));

      verify(UserServiceImplTest.this.userRepository, never()).findUserByIdentification(user.getIdentification());
      verify(UserServiceImplTest.this.userRepository, never()).saveUser(user);
    }

    @Test
    void given_userWithIdentificationThatExists_when_createUser_then_expectedException() {
      final var user = UserMother.withUserId(null);

      when(UserServiceImplTest.this.userRepository.findUserByIdentification(user.getIdentification())).thenReturn(
          Optional.of(UserMother.complete()));

      assertThrows(ServiceException.class, () -> UserServiceImplTest.this.userService.createUser(user));

      verify(UserServiceImplTest.this.userRepository).findUserByIdentification(user.getIdentification());
      verify(UserServiceImplTest.this.userRepository, never()).saveUser(user);
    }

    @Test
    void given_positiveCase_when_createUser_then_userIsCreated() {
      final var user = UserMother.withUserId(null);

      when(UserServiceImplTest.this.userRepository.findUserByIdentification(user.getIdentification())).thenReturn(
          Optional.empty());

      UserServiceImplTest.this.userService.createUser(user);

      verify(UserServiceImplTest.this.userRepository).findUserByIdentification(user.getIdentification());
      verify(UserServiceImplTest.this.userRepository).saveUser(user);
    }
  }

  @Nested
  class UpdateUser {

    @Test
    void given_userWithIdThatDoesNotExists_when_updateUser_then_expectedException() {
      final var user = UserMother.withUserId(9999);

      when(UserServiceImplTest.this.userRepository.findUserById(user.getUserId())).thenReturn(Optional.empty());

      assertThrows(ServiceException.class, () -> UserServiceImplTest.this.userService.updateUser(user));

      verify(UserServiceImplTest.this.userRepository).findUserById(user.getUserId());
      verify(UserServiceImplTest.this.userRepository, never()).findUserByIdentification(user.getIdentification());
      verify(UserServiceImplTest.this.userRepository, never()).saveUser(user);
    }

    @Test
    void given_userWithIdentificationThatExists_when_updateUser_then_expectedException() {
      final var user = UserMother.withUserId(null);

      when(UserServiceImplTest.this.userRepository.findUserById(user.getUserId())).thenReturn(
          Optional.of(UserMother.complete()));
      when(UserServiceImplTest.this.userRepository.findUserByIdentification(user.getIdentification())).thenReturn(
          Optional.of(UserMother.complete()));

      assertThrows(ServiceException.class, () -> UserServiceImplTest.this.userService.updateUser(user));

      verify(UserServiceImplTest.this.userRepository).findUserById(user.getUserId());
      verify(UserServiceImplTest.this.userRepository).findUserByIdentification(user.getIdentification());
      verify(UserServiceImplTest.this.userRepository, never()).saveUser(user);
    }

    @Test
    void given_positiveCase_when_updateUser_then_userIsUpdated() {
      final var user = UserMother.withUserId(null);

      when(UserServiceImplTest.this.userRepository.findUserById(user.getUserId())).thenReturn(
          Optional.of(UserMother.complete()));
      when(UserServiceImplTest.this.userRepository.findUserByIdentification(user.getIdentification())).thenReturn(
          Optional.empty());

      UserServiceImplTest.this.userService.updateUser(user);

      verify(UserServiceImplTest.this.userRepository).findUserById(user.getUserId());
      verify(UserServiceImplTest.this.userRepository).findUserByIdentification(user.getIdentification());
      verify(UserServiceImplTest.this.userRepository).saveUser(user);
    }
  }

  @Nested
  class DeleteUser {

    @Test
    void given_userIdThatNotExists_when_deleteUser_then_expectedException() {
      when(UserServiceImplTest.this.userRepository.findUserById(UserMother.USER_ID)).thenReturn(Optional.empty());

      assertThrows(ServiceException.class, () -> UserServiceImplTest.this.userService.deleteUser(UserMother.USER_ID));

      verify(UserServiceImplTest.this.userRepository).findUserById(UserMother.USER_ID);
      verify(UserServiceImplTest.this.userRepository, never()).deleteUserById(UserMother.USER_ID);
    }

    @Test
    void given_positiveCase_when_deleteUser_then_userIsDeleted() {
      when(UserServiceImplTest.this.userRepository.findUserById(UserMother.USER_ID)).thenReturn(
          Optional.of(UserMother.complete()));

      UserServiceImplTest.this.userService.deleteUser(UserMother.USER_ID);

      verify(UserServiceImplTest.this.userRepository).findUserById(UserMother.USER_ID);
      verify(UserServiceImplTest.this.userRepository).deleteUserById(UserMother.USER_ID);
    }
  }

  @Nested
  class GetAllUsers {

    @Test
    void given_positiveCase_when_getAllUsers_then_expectedUsers() {
      when(UserServiceImplTest.this.userRepository.readUsers()).thenReturn(List.of(UserMother.complete()));

      final var result = UserServiceImplTest.this.userService.getAllUsers();

      assertNotNull(result);
      assertEquals(1, result.size());
      assertEquals(UserMother.complete(), result.get(0));
      verify(UserServiceImplTest.this.userRepository).readUsers();
    }
  }

  @Nested
  class GetUserById {

    @Test
    void given_userIdThatNotExists_when_getUserById_then_expectedException() {
      when(UserServiceImplTest.this.userRepository.findUserById(UserMother.USER_ID)).thenReturn(Optional.empty());

      assertThrows(ServiceException.class, () -> UserServiceImplTest.this.userService.getUserById(UserMother.USER_ID));

      verify(UserServiceImplTest.this.userRepository).findUserById(UserMother.USER_ID);
    }

    @Test
    void given_positiveCase_when_getUserById_then_expectedUser() {
      when(UserServiceImplTest.this.userRepository.findUserById(UserMother.USER_ID)).thenReturn(
          Optional.of(UserMother.complete()));

      final var result = UserServiceImplTest.this.userService.getUserById(UserMother.USER_ID);

      assertNotNull(result);
      assertEquals(UserMother.complete(), result);
      verify(UserServiceImplTest.this.userRepository).findUserById(UserMother.USER_ID);
    }
  }
}