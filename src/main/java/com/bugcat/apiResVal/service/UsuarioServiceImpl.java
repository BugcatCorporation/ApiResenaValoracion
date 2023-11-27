package com.bugcat.apiResVal.service;

import com.bugcat.apiResVal.dao.UsuarioRepository;
import com.bugcat.apiResVal.dto.UsuarioDto;
import com.bugcat.apiResVal.entity.ResenaValoracion;
import com.bugcat.apiResVal.entity.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ApiRestClient apiRestClient;

    @Override
    public List<UsuarioDto> findAll() {
        log.info("Obteniendo todos los usuarios.");
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDto> usuariosDto = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            ResenaValoracion resenaval = apiRestClient.findByResenavalSK(usuario.getResenavalSK());

            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(usuario.getId());
            usuarioDto.setUsuario(usuario.getUsuario());
            usuarioDto.setContrasena(usuario.getContrasena());
            usuarioDto.setCorreo(usuario.getCorreo());
            usuarioDto.setNombre(usuario.getNombre());
            usuarioDto.setEstado(usuario.getEstado());
            usuarioDto.setApellido(usuario.getApellido());
            usuarioDto.setResenaval(resenaval);

            usuariosDto.add(usuarioDto);
        }

        log.info("Usuarios obtenidos exitosamente.");
        return usuariosDto;
    }

    @Override
    public Usuario add(Usuario usuario) {
        log.info("Agregando nuevo usuario: {}", usuario);
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioDto findById(Long id) {
        log.info("Obteniendo el usuario con el ID: {}", id);
        Usuario usuario = usuarioRepository.findById(id).get();

        ResenaValoracion resenaval = apiRestClient.findByResenavalSK(usuario.getResenavalSK());

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setUsuario(usuario.getUsuario());
        usuarioDto.setContrasena(usuario.getContrasena());
        usuarioDto.setCorreo(usuario.getCorreo());
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setEstado(usuario.getEstado());
        usuarioDto.setApellido(usuario.getApellido());
        usuarioDto.setResenaval(resenaval);

        log.info("Usuario obtenido exitosamente con el ID: {}", id);
        return usuarioDto;
    }

    // Otros métodos del servicio...

}
