package com.devsu.user.apirest.user.mapper;

import java.util.List;

import com.devsu.user.apirest.user.dto.UserRequestDto;
import com.devsu.user.apirest.user.dto.UserResponseDto;
import com.devsu.user.apirest.user.dto.UserToPatchRequestDto;
import com.devsu.user.domain.entity.User;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

  List<UserResponseDto> fromDomain(List<User> users);

  @Mapping(target = "clienteId", source = "userId")
  @Mapping(target = "nombre", source = "name")
  @Mapping(target = "genero", source = "gender")
  @Mapping(target = "edad", source = "age")
  @Mapping(target = "identificacion", source = "identification")
  @Mapping(target = "direccion", source = "address")
  @Mapping(target = "telefono", source = "phone")
  @Mapping(target = "contrasena", source = "password")
  @Mapping(target = "activo", source = "active")
  UserResponseDto fromDomain(final User users);

  @Mapping(target = "personId", ignore = true)
  @Mapping(target = "userId", expression = "java(id)")
  @Mapping(target = "name", source = "nombre")
  @Mapping(target = "gender", source = "genero")
  @Mapping(target = "age", source = "edad")
  @Mapping(target = "identification", source = "identificacion")
  @Mapping(target = "address", source = "direccion")
  @Mapping(target = "phone", source = "telefono")
  @Mapping(target = "password", source = "contrasena")
  @Mapping(target = "active", source = "activo")
  User toDomain(UserRequestDto userRequestDto, @Context Integer id);

  default User toDomain(UserRequestDto userRequestDto) {
    return this.toDomain(userRequestDto, null);
  }

  @Mapping(target = "personId", ignore = true)
  @Mapping(target = "active", ignore = true)
  @Mapping(target = "userId", expression = "java(id)")
  @Mapping(target = "name", source = "nombre")
  @Mapping(target = "gender", source = "genero")
  @Mapping(target = "age", source = "edad")
  @Mapping(target = "identification", source = "identificacion")
  @Mapping(target = "address", source = "direccion")
  @Mapping(target = "phone", source = "telefono")
  @Mapping(target = "password", source = "contrasena")
  User toDomain(UserToPatchRequestDto userRequestDto, @Context Integer id);

  default User toDomain(UserToPatchRequestDto userRequestDto) {
    return this.toDomain(userRequestDto, null);
  }

}
