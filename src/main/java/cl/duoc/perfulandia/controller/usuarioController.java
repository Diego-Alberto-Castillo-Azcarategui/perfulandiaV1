package cl.duoc.perfulandia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/usuarios")

public class usuarioController {


    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        return ResponseEntity.ok(usuarioServicio.obtenerUsuarios());
    }

    @GetMapping("/id")
    public ResponseEntity <Usuario> obtenerUsuarioPorId(@PathVariable int id) {
        return ResponseEntity.ok(usuarioServicio.obtenerUsuarioPorId(id));
    }
}




}
