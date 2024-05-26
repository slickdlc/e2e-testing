package com.devsu.user.domain.usecase;

import com.devsu.user.domain.entity.User;

public interface UpdateUserUseCase {

  void handle(final User user);
}
