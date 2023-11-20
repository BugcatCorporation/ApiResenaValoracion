
package com.bugcat.apiResVal.dao;

import com.bugcat.apiResVal.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
