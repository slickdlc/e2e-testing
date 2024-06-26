package com.tecra.user.apirest.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

  private Integer usuarioId;

  private String nombre;

  private String genero;

  private Integer edad;

  private String identificacion;

  private String direccion;

  private String telefono;

  private String contrasena;

  private boolean activo;

}
