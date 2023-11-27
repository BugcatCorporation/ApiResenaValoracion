
package com.bugcat.apiResVal.service;

import com.bugcat.apiResVal.dto.UsuarioDto;
import com.bugcat.apiResVal.entity.Usuario;
import java.util.List;


public interface UsuarioService {
     List<UsuarioDto> findAll();
     Usuario add(Usuario usuario);
     UsuarioDto findById(Long id);
}
