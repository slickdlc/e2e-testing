package com.devsu.user.application.usecase;

import java.util.List;

import com.devsu.user.domain.entity.User;
import com.devsu.user.domain.exception.ServiceException;
import com.devsu.user.domain.exception.UseCaseException;
import com.devsu.user.domain.service.UserService;
import com.devsu.user.domain.usecase.GetAllUsersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAllUsersUseCaseImpl implements GetAllUsersUseCase {

  private final UserService userService;

  @Override
  public List<User> handle() {
    try {
      return this.userService.getAllUsers();
    } catch (ServiceException e) {
      throw new UseCaseException(e);
    }
  }
}
