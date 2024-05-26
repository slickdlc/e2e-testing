package com.devsu.user.application.usecase;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import com.devsu.UserMother;
import com.devsu.user.domain.exception.ServiceException;
import com.devsu.user.domain.exception.UseCaseException;
import com.devsu.user.domain.service.UserService;
import com.devsu.user.application.usecase.UpdateUserUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateUserUseCaseImplTest {

  @InjectMocks
  private UpdateUserUseCaseImpl useCase;

  @Mock
  private UserService userService;

  @Test
  void given_serviceWorks_when_handle_then_successUseCase() {
    assertDoesNotThrow(() -> this.useCase.handle(UserMother.complete()));

    verify(this.userService).updateUser(UserMother.complete());
  }

  @Test
  void given_serviceFails_when_handle_then_throwUseCaseException() {
    doThrow(ServiceException.class).when(this.userService).updateUser(UserMother.complete());

    assertThrows(UseCaseException.class, () -> this.useCase.handle(UserMother.complete()));

    verify(this.userService).updateUser(UserMother.complete());
  }
}