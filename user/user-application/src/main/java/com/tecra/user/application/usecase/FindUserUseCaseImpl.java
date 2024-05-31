package com.tecra.user.application.usecase;

import com.tecra.user.domain.entity.User;
import com.tecra.user.domain.exception.ServiceException;
import com.tecra.user.domain.exception.UseCaseException;
import com.tecra.user.domain.service.UserService;
import com.tecra.user.domain.usecase.FindUserUseCase;
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
