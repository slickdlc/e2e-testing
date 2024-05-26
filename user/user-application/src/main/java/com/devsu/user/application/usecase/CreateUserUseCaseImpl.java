package com.devsu.user.application.usecase;

import com.devsu.user.domain.entity.User;
import com.devsu.user.domain.exception.ServiceException;
import com.devsu.user.domain.exception.UseCaseException;
import com.devsu.user.domain.service.UserService;
import com.devsu.user.domain.usecase.CreateUserUseCase;
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
