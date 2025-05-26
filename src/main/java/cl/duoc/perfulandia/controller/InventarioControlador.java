package cl.duoc.perfulandia.controller;

import cl.duoc.perfulandia.dto.MessageResponse;
import cl.duoc.perfulandia.service.InventarioServicio;
import cl.duoc.perfulandia.service.dominio.Inventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")

public class InventarioControlador {
    @Autowired
    private InventarioServicio inventarioServicio;

    @GetMapping
    public ResponseEntity<List<Inventario>> listar() {
        return ResponseEntity.ok(InventarioServicio.getInventario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> buscarPorId(@PathVariable String id) {
        Inventario encontrado = inventarioServicio.getInventario(id);
        if (encontrado != null) {
            return ResponseEntity.ok(encontrado);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<MessageResponse> crearProducto(
            @RequestBody Inventario request) {
        boolean agregado = inventarioServicio.agregarInventario(request);
        if (!agregado) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new MessageResponse("Error al agregar Producto"));
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new MessageResponse("Producto creado."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> actualizarInventario(
            @PathVariable String id,
            @RequestBody Inventario request) {
        boolean actualizado = inventarioServicio.actualizarInventario(id, request);
        if (!actualizado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MessageResponse("Producto modificado"));
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> eliminarInventario(@PathVariable String id) {
        boolean eliminado = inventarioServicio.eliminarInventario(id);
        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new MessageResponse("Producto eliminado"));
     }
}
