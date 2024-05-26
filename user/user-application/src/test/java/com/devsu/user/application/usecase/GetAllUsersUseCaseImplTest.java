package com.devsu.user.application.usecase;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import com.devsu.UserMother;
import com.devsu.user.domain.exception.ServiceException;
import com.devsu.user.domain.exception.UseCaseException;
import com.devsu.user.domain.service.UserService;
import com.devsu.user.application.usecase.GetAllUsersUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetAllUsersUseCaseImplTest {

  @InjectMocks
  private GetAllUsersUseCaseImpl useCase;

  @Mock
  private UserService userService;

  @Test
  void given_serviceWorks_when_handle_then_successUseCase() {
    when(this.userService.getAllUsers()).thenReturn(List.of(UserMother.complete()));

    assertDoesNotThrow(() -> this.useCase.handle());

    verify(this.userService).getAllUsers();
  }

  @Test
  void given_serviceFails_when_handle_then_throwUseCaseException() {
    doThrow(ServiceException.class).when(this.userService).getAllUsers();

    assertThrows(UseCaseException.class, () -> this.useCase.handle());

    verify(this.userService).getAllUsers();
  }
}