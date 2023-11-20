
package com.bugcat.apiResVal.service;

import com.bugcat.apiResVal.dao.UsuarioRepository;
import com.bugcat.apiResVal.dto.UsuarioDto;
import com.bugcat.apiResVal.entity.ResenaValoracion;
import com.bugcat.apiResVal.entity.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

   @Autowired
    private UsuarioRepository usuarioRepository;
   @Autowired
    private ApiRestClient apiRestClient;

    @Override
    public List<Usuario> findAll() {
       return usuarioRepository.findAll();
    }

    @Override
    public Usuario add(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        var usuarioDb = usuarioRepository.findById(usuario.getId()).get();
        usuarioDb.setUsuario(usuario.getUsuario());
        usuarioDb.setContrasena(usuario.getContrasena());
        usuarioDb.setCorreo(usuario.getCorreo());
        usuarioDb.setNombre(usuario.getNombre());
        usuarioDb.setApellido(usuario.getApellido());
        usuarioDb.setResenavalSK(usuario.getResenavalSK());
        return usuarioRepository.save(usuarioDb);
    }

    @Override
    public void delete(long id) {
       var usuarioDb = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuarioDb);
    }

    @Override
    public UsuarioDto findById(Long id) {
       Usuario usuario = usuarioRepository
                .findById(id).get();
        
        ResenaValoracion resenaval =
                apiRestClient
           .findByResenavalSK(usuario.getResenavalSK());
        
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setUsuario( usuario.getUsuario());
        usuarioDto.setContrasena(usuario.getContrasena());
        usuarioDto.setCorreo(usuario.getCorreo());
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setApellido(usuario.getApellido());
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setResenaval(resenaval);
        return usuarioDto;
        
    }
    
    
    }
    
   

