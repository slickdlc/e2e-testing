package com.devsu.user.domain.usecase;

import java.util.List;

import com.devsu.user.domain.entity.User;

public interface GetAllUsersUseCase {

  List<User> handle();
}
