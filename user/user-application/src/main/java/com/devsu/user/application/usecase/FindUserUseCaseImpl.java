package com.devsu.user.application.usecase;

import com.devsu.user.domain.entity.User;
import com.devsu.user.domain.exception.ServiceException;
import com.devsu.user.domain.exception.UseCaseException;
import com.devsu.user.domain.service.UserService;
import com.devsu.user.domain.usecase.FindUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindUserUseCaseImpl implements FindUserUseCase {

  private final UserService userService;

  @Override
  public User handle(final Integer id) {
    try {
      return this.userService.getUserById(id);
    } catch (ServiceException e) {
      throw new UseCaseException(e);
    }
  }

  @Override
  public User handle(final String identification) {
    try {
      return this.userService.getUserByIdentification(identification);
    } catch (ServiceException e) {
      throw new UseCaseException(e);
    }
  }
}
