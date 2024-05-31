package com.tecra.user.domain.usecase;

import java.util.List;

import com.tecra.user.domain.entity.User;

public interface GetAllUsersUseCase {

  List<User> handle();
}
