package com.tecra.user.infrastructure.mapper;

import java.util.List;

import com.tecra.user.domain.entity.User;
import com.tecra.user.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

  UserEntity fromDomain(final User user);

  @Mapping(target = "personId", ignore = true)
  User toDomain(UserEntity userEntity);

  List<User> toDomain(List<UserEntity> userEntities);
}
