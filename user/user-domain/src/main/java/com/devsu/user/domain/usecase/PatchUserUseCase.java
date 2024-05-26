package com.devsu.user.domain.usecase;

import com.devsu.user.domain.entity.User;

public interface PatchUserUseCase {

  void handle(final User user);
}
