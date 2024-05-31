package com.tecra.user.application.usecase;

import java.util.List;

import com.tecra.user.domain.entity.User;
import com.tecra.user.domain.exception.ServiceException;
import com.tecra.user.domain.exception.UseCaseException;
import com.tecra.user.domain.service.UserService;
import com.tecra.user.domain.usecase.GetAllUsersUseCase;
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
