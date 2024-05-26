package com.devsu.user.apirest.user.controller;

import java.util.List;

import com.devsu.user.apirest.common.BaseController;
import com.devsu.user.apirest.common.dto.SuccessMessageDto;
import com.devsu.user.apirest.user.dto.UserRequestDto;
import com.devsu.user.apirest.user.dto.UserResponseDto;
import com.devsu.user.apirest.user.dto.UserToPatchRequestDto;
import com.devsu.user.apirest.user.mapper.UserMapper;
import com.devsu.user.domain.usecase.CreateUserUseCase;
import com.devsu.user.domain.usecase.DeleteUserUseCase;
import com.devsu.user.domain.usecase.FindUserUseCase;
import com.devsu.user.domain.usecase.GetAllUsersUseCase;
import com.devsu.user.domain.usecase.PatchUserUseCase;
import com.devsu.user.domain.usecase.UpdateUserUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class UserController extends BaseController {

  private static final String USER_CREATED_SUCCESSFULLY = "El cliente ha sido creado satisfactoriamente";

  private static final String USER_UPDATED_SUCCESSFULLY = "El cliente ha sido actualizado satisfactoriamente";

  private static final String USER_DELETED_SUCCESSFULLY = "El cliente ha sido eliminado satisfactoriamente";

  private final CreateUserUseCase createUserUseCase;

  private final GetAllUsersUseCase getAllUsersUseCase;

  private final FindUserUseCase findUserUseCase;

  private final UpdateUserUseCase updateUserUseCase;

  private final PatchUserUseCase patchUserUseCase;

  private final DeleteUserUseCase deleteUserUseCase;

  private final UserMapper userMapper;

  @GetMapping
  public ResponseEntity<List<UserResponseDto>> getAllUsers() {
    return ok(this.userMapper.fromDomain(this.getAllUsersUseCase.handle()));
  }

  @PostMapping
  public ResponseEntity<SuccessMessageDto> createUser(@Valid @NotNull @RequestBody final UserRequestDto requestDto) {
    this.createUserUseCase.handle(this.userMapper.toDomain(requestDto));
    return createSuccessMessage(USER_CREATED_SUCCESSFULLY);
  }

  @PutMapping("/{id}")
  public ResponseEntity<SuccessMessageDto> updateUser(@Valid @NotNull @RequestBody final UserRequestDto requestDto,
      @Valid @NotNull @PathVariable("id") Integer id) {
    this.updateUserUseCase.handle(this.userMapper.toDomain(requestDto, id));
    return createSuccessMessage(USER_UPDATED_SUCCESSFULLY);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<SuccessMessageDto> patchUser(@Valid @NotNull @RequestBody final UserToPatchRequestDto requestDto,
      @Valid @NotNull @PathVariable("id") Integer id) {
    this.patchUserUseCase.handle(this.userMapper.toDomain(requestDto, id));
    return createSuccessMessage(USER_UPDATED_SUCCESSFULLY);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<SuccessMessageDto> deleteUser(@Valid @NotNull @PathVariable("id") Integer id) {
    this.deleteUserUseCase.handle(id);
    return createSuccessMessage(USER_DELETED_SUCCESSFULLY);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponseDto> getUser(@Valid @NotNull @PathVariable("id") final Integer id) {
    return ok(this.userMapper.fromDomain(this.findUserUseCase.handle(id)));
  }

  @GetMapping("/identification/{id}")
  public ResponseEntity<UserResponseDto> getUser(@Valid @NotNull @PathVariable("id") final String identification) {
    return ok(this.userMapper.fromDomain(this.findUserUseCase.handle(identification)));
  }

}
