package com.devsu.user.application.usecase;

import com.devsu.user.domain.exception.ServiceException;
import com.devsu.user.domain.exception.UseCaseException;
import com.devsu.user.domain.service.UserService;
import com.devsu.user.domain.usecase.DeleteUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

  private final UserService userService;

  @Override
  public void handle(final Integer id) {
    try {
      this.userService.deleteUser(id);
    } catch (ServiceException e) {
      throw new UseCaseException(e);
    }
  }
}
