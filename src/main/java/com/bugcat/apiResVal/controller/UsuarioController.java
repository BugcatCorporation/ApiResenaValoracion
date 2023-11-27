package com.bugcat.apiResVal.controller;

import com.bugcat.apiResVal.dto.UsuarioDto;
import com.bugcat.apiResVal.entity.Usuario;
import com.bugcat.apiResVal.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuario")
@Slf4j
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("add")
    public ResponseEntity<Usuario> add(@RequestBody Usuario usuario) {
        log.info("Recibiendo solicitud para agregar un nuevo usuario: {}", usuario);
        Usuario nuevoUsuario = usuarioService.add(usuario);
        log.info("Nuevo usuario agregado exitosamente: {}", nuevoUsuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<UsuarioDto> findById(@PathVariable Long id) {
        log.info("Recibiendo solicitud para buscar un usuario por ID: {}", id);
        UsuarioDto usuarioDto = usuarioService.findById(id);
        log.info("Usuario encontrado por ID {}: {}", id, usuarioDto);
        return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
    }

    @GetMapping("findAll")
    public ResponseEntity<List<UsuarioDto>> findAll() {
        log.info("Recibiendo solicitud para obtener todos los usuarios.");
        List<UsuarioDto> usuarios = usuarioService.findAll();
        log.info("Usuarios obtenidos exitosamente: {}", usuarios);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
}
