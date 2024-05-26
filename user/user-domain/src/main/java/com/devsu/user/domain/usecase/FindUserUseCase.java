package com.devsu.user.domain.usecase;

import com.devsu.user.domain.entity.User;

public interface FindUserUseCase {

  User handle(final Integer id);

  User handle(final String identification);
}
