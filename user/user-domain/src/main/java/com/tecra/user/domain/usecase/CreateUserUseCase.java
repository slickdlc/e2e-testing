package com.tecra.user.domain.usecase;

import com.tecra.user.domain.entity.User;

public interface CreateUserUseCase {

  void handle(final User user);
}
