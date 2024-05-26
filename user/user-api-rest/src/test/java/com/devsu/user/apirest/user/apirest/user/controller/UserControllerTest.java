package com.devsu.user.apirest.user.apirest.user.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import com.devsu.UserMother;
import com.devsu.user.apirest.user.controller.UserController;
import com.devsu.user.apirest.user.apirest.user.dto.UserRequestDtoMother;
import com.devsu.user.apirest.user.mapper.UserMapperImpl;
import com.devsu.user.domain.entity.User;
import com.devsu.user.domain.exception.UseCaseException;
import com.devsu.user.domain.usecase.CreateUserUseCase;
import com.devsu.user.domain.usecase.DeleteUserUseCase;
import com.devsu.user.domain.usecase.FindUserUseCase;
import com.devsu.user.domain.usecase.GetAllUsersUseCase;
import com.devsu.user.domain.usecase.UpdateUserUseCase;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

  @InjectMocks
  private UserController controller;

  @Mock
  private CreateUserUseCase createUserUseCase;

  @Mock
  private GetAllUsersUseCase getAllUsersUseCase;

  @Mock
  private FindUserUseCase findUserUseCase;

  @Mock
  private UpdateUserUseCase updateUserUseCase;

  @Mock
  private DeleteUserUseCase deleteUserUseCase;

  @Spy
  private UserMapperImpl userMapper;

  @Nested
  class GetAllUsers {

    @Test
    void given_useCaseWorks_when_getAllUsers_then_returnExpectedUsers() {
      when(UserControllerTest.this.getAllUsersUseCase.handle()).thenReturn(List.of(UserMother.complete()));

      final var result = UserControllerTest.this.controller.getAllUsers();

      assertNotNull(result);
      assertEquals(HttpStatus.OK, result.getStatusCode());
      assertNotNull(result.getBody());
      assertEquals(1, result.getBody().size());
      verify(UserControllerTest.this.getAllUsersUseCase).handle();
      verify(UserControllerTest.this.userMapper).fromDomain(anyList());

    }

    @Test
    void given_useCaseFails_when_getAllUsers_then_throwUseCaseException() {
      when(UserControllerTest.this.getAllUsersUseCase.handle()).thenThrow(UseCaseException.class);

      assertThrows(UseCaseException.class, () -> UserControllerTest.this.controller.getAllUsers());

      verify(UserControllerTest.this.getAllUsersUseCase).handle();
    }
  }

  @Nested
  class CreateUser {

    @Test
    void given_useCaseWorks_when_createUser_then_returnExpectedMessage() {
      final var result = UserControllerTest.this.controller.createUser(UserRequestDtoMother.complete());

      assertNotNull(result);
      assertEquals(HttpStatus.OK, result.getStatusCode());
      assertNotNull(result.getBody());
      assertEquals("El cliente ha sido creado satisfactoriamente", result.getBody().getMessage());
      verify(UserControllerTest.this.createUserUseCase).handle(any());
    }

    @Test
    void given_useCaseFails_when_createUser_then_throwUseCaseException() {
      doThrow(UseCaseException.class).when(UserControllerTest.this.createUserUseCase).handle(any());

      assertThrows(UseCaseException.class,
          () -> UserControllerTest.this.controller.createUser(UserRequestDtoMother.complete()));

      verify(UserControllerTest.this.createUserUseCase).handle(any());
    }
  }

  @Nested
  class FindUser {

    @Test
    void given_useCaseWorks_when_findUser_then_returnExpectedUser() {
      when(UserControllerTest.this.findUserUseCase.handle(UserMother.USER_ID)).thenReturn(UserMother.complete());

      final var result = UserControllerTest.this.controller.getUser(UserMother.USER_ID);

      assertNotNull(result);
      assertEquals(HttpStatus.OK, result.getStatusCode());
      assertNotNull(result.getBody());
      verify(UserControllerTest.this.findUserUseCase).handle(UserMother.USER_ID);
      verify(UserControllerTest.this.userMapper).fromDomain(any(User.class));
    }

    @Test
    void given_useCaseFails_when_findUser_then_throwUseCaseException() {
      when(UserControllerTest.this.findUserUseCase.handle(UserMother.USER_ID)).thenThrow(UseCaseException.class);

      assertThrows(UseCaseException.class, () -> UserControllerTest.this.controller.getUser(UserMother.USER_ID));

      verify(UserControllerTest.this.findUserUseCase).handle(UserMother.USER_ID);
    }

  }

  @Nested
  class UpdateUser {

    @Test
    void given_useCaseWorks_when_updateUser_then_returnExpectedMessage() {
      final var result =
          UserControllerTest.this.controller.updateUser(UserRequestDtoMother.complete(), UserMother.USER_ID);

      assertNotNull(result);
      assertEquals(HttpStatus.OK, result.getStatusCode());
      assertNotNull(result.getBody());
      assertEquals("El cliente ha sido actualizado satisfactoriamente", result.getBody().getMessage());
      verify(UserControllerTest.this.updateUserUseCase).handle(any());
    }

    @Test
    void given_useCaseFails_when_updateUser_then_throwUseCaseException() {
      doThrow(UseCaseException.class).when(UserControllerTest.this.updateUserUseCase).handle(any());

      assertThrows(UseCaseException.class,
          () -> UserControllerTest.this.controller.updateUser(UserRequestDtoMother.complete(), UserMother.USER_ID));

      verify(UserControllerTest.this.updateUserUseCase).handle(any());
    }
  }

  @Nested
  class DeleteUser {

    @Test
    void given_useCaseWorks_when_deleteUser_then_returnExpectedMessage() {
      final var result =
          UserControllerTest.this.controller.deleteUser(UserMother.USER_ID);

      assertNotNull(result);
      assertEquals(HttpStatus.OK, result.getStatusCode());
      assertNotNull(result.getBody());
      assertEquals("El cliente ha sido eliminado satisfactoriamente", result.getBody().getMessage());
      verify(UserControllerTest.this.deleteUserUseCase).handle(UserMother.USER_ID);
    }

    @Test
    void given_useCaseFails_when_deleteUser_then_throwUseCaseException() {
      doThrow(UseCaseException.class).when(UserControllerTest.this.deleteUserUseCase).handle(any());

      assertThrows(UseCaseException.class, () -> UserControllerTest.this.controller.deleteUser(UserMother.USER_ID));

      verify(UserControllerTest.this.deleteUserUseCase).handle(UserMother.USER_ID);

    }
  }


}