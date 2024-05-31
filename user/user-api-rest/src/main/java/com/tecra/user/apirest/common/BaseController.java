package com.tecra.user.apirest.common;

import com.tecra.user.apirest.common.dto.SuccessMessageDto;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

  protected static ResponseEntity<SuccessMessageDto> createSuccessMessage(final String message) {
    return ResponseEntity.ok(SuccessMessageDto.builder().message(message).build());
  }

  protected static <T> ResponseEntity<T> ok(final T t) {
    return ResponseEntity.ok(t);
  }
}
