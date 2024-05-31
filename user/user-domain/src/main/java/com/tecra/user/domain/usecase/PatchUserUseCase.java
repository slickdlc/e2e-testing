package com.tecra.user.domain.usecase;

import com.tecra.user.domain.entity.User;

public interface PatchUserUseCase {

  void handle(final User user);
}
