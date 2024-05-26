package com.devsu.user.infrastructure.mapper;

import java.util.List;

import com.devsu.user.domain.entity.User;
import com.devsu.user.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

  UserEntity fromDomain(final User user);

  @Mapping(target = "personId", ignore = true)
  User toDomain(UserEntity userEntity);

  List<User> toDomain(List<UserEntity> userEntities);
}
