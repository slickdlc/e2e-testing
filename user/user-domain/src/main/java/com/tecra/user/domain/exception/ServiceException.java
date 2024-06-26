package com.tecra.user.domain.exception;

import java.io.Serial;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class ServiceException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = -2938719823791231233L;

  private final HttpStatusCode statusCode;

  public ServiceException(final HttpStatusCode statusCode,final String message) {
    super(message);
    this.statusCode = statusCode;
  }
}