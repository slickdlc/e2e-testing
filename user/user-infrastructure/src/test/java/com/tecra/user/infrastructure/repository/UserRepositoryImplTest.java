package com.tecra.user.infrastructure.repository;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import com.tecra.UserMother;
import com.tecra.user.infrastructure.entity.UserEntityMother;
import com.tecra.user.infrastructure.mapper.UserEntityMapperImpl;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.orm.jpa.JpaSystemException;

@ExtendWith(MockitoExtension.class)
class UserRepositoryImplTest {

  @InjectMocks
  private UserRepositoryImpl userRepository;

  @Mock
  private UserJpaRepository userJpaRepository;

  @Spy
  private UserEntityMapperImpl userMapper;

  @Nested
  class SaveUser {

    @Test
    void given_negativeCase_when_saveUser_then_throwsException() {
      when(UserRepositoryImplTest.this.userJpaRepository.save(any())).thenThrow(JpaSystemException.class);

      assertThrows(JpaSystemException.class,
          () -> UserRepositoryImplTest.this.userRepository.saveUser(UserMother.complete()));
    }

    @Test
    void given_positiveCase_when_saveUser_then_returnUser() {
      UserRepositoryImplTest.this.userRepository.saveUser(UserMother.complete());

      verify(UserRepositoryImplTest.this.userJpaRepository).save(any());
    }
  }

  @Nested
  class DeleteUserById {

    @Test
    void given_negativeCase_when_deleteUserById_then_throwsException() {
      doThrow(JpaSystemException.class).when(UserRepositoryImplTest.this.userJpaRepository).deleteById(any());

      assertThrows(JpaSystemException.class,
          () -> UserRepositoryImplTest.this.userRepository.deleteUserById(UserMother.USER_ID));

      verify(UserRepositoryImplTest.this.userJpaRepository).deleteById(UserMother.USER_ID);
    }

    @Test
    void given_positiveCase_when_deleteUserById_then_returnUser() {
      doNothing().when(UserRepositoryImplTest.this.userJpaRepository).deleteById(any());

      UserRepositoryImplTest.this.userRepository.deleteUserById(UserMother.USER_ID);

      verify(UserRepositoryImplTest.this.userJpaRepository).deleteById(UserMother.USER_ID);
    }
  }

  @Nested
  class ReadUsers {

    @Test
    void given_negativeCase_when_readUsers_then_throwsException() {
      when(UserRepositoryImplTest.this.userJpaRepository.findAll()).thenThrow(JpaSystemException.class);

      assertThrows(JpaSystemException.class, () -> UserRepositoryImplTest.this.userRepository.readUsers());

      verify(UserRepositoryImplTest.this.userJpaRepository).findAll();
    }

    @Test
    void given_positiveCase_when_readUsers_then_returnUsers() {
      when(UserRepositoryImplTest.this.userJpaRepository.findAll()).thenReturn(List.of(UserEntityMother.complete()));

      UserRepositoryImplTest.this.userRepository.readUsers();

      verify(UserRepositoryImplTest.this.userJpaRepository).findAll();
    }
  }

  @Nested
  class FindUserById {

    @Test
    void given_negativeCase_when_findUserById_then_throwsException() {
      when(UserRepositoryImplTest.this.userJpaRepository.findById(UserMother.USER_ID)).thenThrow(JpaSystemException.class);

      assertThrows(JpaSystemException.class,
          () -> UserRepositoryImplTest.this.userRepository.findUserById(UserMother.USER_ID));

      verify(UserRepositoryImplTest.this.userJpaRepository).findById(UserMother.USER_ID);
    }

    @Test
    void given_positiveCase_when_findUserById_then_returnUser() {
      when(UserRepositoryImplTest.this.userJpaRepository.findById(UserMother.USER_ID)).thenReturn(
          java.util.Optional.of(UserEntityMother.complete()));

      UserRepositoryImplTest.this.userRepository.findUserById(UserMother.USER_ID);

      verify(UserRepositoryImplTest.this.userJpaRepository).findById(UserMother.USER_ID);
    }
  }

  @Nested
  class FindUserByIdentification {

    @Test
    void given_negativeCase_when_findUserByIdentification_then_throwsException() {
      when(UserRepositoryImplTest.this.userJpaRepository.findByIdentification(UserMother.IDENTIFICATION)).thenThrow(
          JpaSystemException.class);

      assertThrows(JpaSystemException.class,
          () -> UserRepositoryImplTest.this.userRepository.findUserByIdentification(UserMother.IDENTIFICATION));

      verify(UserRepositoryImplTest.this.userJpaRepository).findByIdentification(UserMother.IDENTIFICATION);
    }

    @Test
    void given_positiveCase_when_findUserByIdentification_then_returnUser() {
      when(UserRepositoryImplTest.this.userJpaRepository.findByIdentification(UserMother.IDENTIFICATION)).thenReturn(
          java.util.Optional.of(UserEntityMother.complete()));

      UserRepositoryImplTest.this.userRepository.findUserByIdentification(UserMother.IDENTIFICATION);

      verify(UserRepositoryImplTest.this.userJpaRepository).findByIdentification(UserMother.IDENTIFICATION);
    }
  }

}