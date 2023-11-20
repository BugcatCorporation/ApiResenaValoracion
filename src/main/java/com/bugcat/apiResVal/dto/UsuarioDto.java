
package com.bugcat.apiResVal.dto;

import com.bugcat.apiResVal.entity.ResenaValoracion;
import lombok.Data;

@Data
public class UsuarioDto {
    private Long id;
    private String usuario;
    private String contrasena;
    private String correo;
    private String nombre;
    private String apellido;
    private String estado;
    private ResenaValoracion resenaval;
}
