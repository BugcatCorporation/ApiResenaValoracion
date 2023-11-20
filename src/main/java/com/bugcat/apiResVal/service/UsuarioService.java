
package com.bugcat.apiResVal.service;

import com.bugcat.apiResVal.dto.UsuarioDto;
import com.bugcat.apiResVal.entity.Usuario;
import java.util.List;


public interface UsuarioService {
     List<Usuario> findAll();
     Usuario add(Usuario usuario);
     Usuario update(Usuario usuario);
     public void delete(long id);
      UsuarioDto findById(Long id);
}
