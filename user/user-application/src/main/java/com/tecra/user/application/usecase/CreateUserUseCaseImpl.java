package com.tecra.user.application.usecase;

import com.tecra.user.domain.entity.User;
import com.tecra.user.domain.exception.ServiceException;
import com.tecra.user.domain.exception.UseCaseException;
import com.tecra.user.domain.service.UserService;
import com.tecra.user.domain.usecase.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

  private final UserService userService;

  @Override
  public void handle(final User user) {
    try {
      this.userService.createUser(user);
    } catch (ServiceException e) {
      throw new UseCaseException(e);
    }
  }
}
