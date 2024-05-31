package com.tecra.user.application.usecase;

import com.tecra.user.domain.exception.ServiceException;
import com.tecra.user.domain.exception.UseCaseException;
import com.tecra.user.domain.service.UserService;
import com.tecra.user.domain.usecase.DeleteUserUseCase;
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
