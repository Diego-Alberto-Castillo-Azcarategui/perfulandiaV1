package cl.duoc.perfulandia.controller;

import cl.duoc.perfulandia.dto.MessageResponse;
import cl.duoc.perfulandia.service.InventarioServicio;
import cl.duoc.perfulandia.service.UsuarioServicio;
import cl.duoc.perfulandia.service.dominio.Inventario;
import cl.duoc.perfulandia.service.dominio.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Inventario")


public class InventarioControlador {
    @Autowired
    private InventarioServicio inventarioServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping
    public ResponseEntity<Inventario> listarInventarios() {}
}
