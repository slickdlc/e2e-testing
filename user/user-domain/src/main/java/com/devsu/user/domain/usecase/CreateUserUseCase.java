package com.devsu.user.domain.usecase;

import com.devsu.user.domain.entity.User;

public interface CreateUserUseCase {

  void handle(final User user);
}
