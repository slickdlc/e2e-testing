package com.tecra.user.domain.usecase;

import com.tecra.user.domain.entity.User;

public interface FindUserUseCase {

  User handle(final Integer id);

  User handle(final String identification);
}
