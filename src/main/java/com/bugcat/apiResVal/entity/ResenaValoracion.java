
package com.bugcat.apiResVal.entity;
import java.util.Date;
import lombok.Data;

@Data
public class ResenaValoracion {
    private Long id;
    private String comentario;
    private int valoracion;
    private Date fecha;
    private String titulo;
    private String resenavalSK;
}
