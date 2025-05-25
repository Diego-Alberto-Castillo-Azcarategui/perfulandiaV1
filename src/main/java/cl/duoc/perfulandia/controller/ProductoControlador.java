package cl.duoc.perfulandia.controller;

import cl.duoc.perfulandia.dto.MessageResponse;
import cl.duoc.perfulandia.service.ProductoServicio;
import cl.duoc.perfulandia.service.UsuarioServicio;
import cl.duoc.perfulandia.service.dominio.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Producto")

public class ProductoControlador {
    @Autowired
    private ProductoServicio productoServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {
        return ResponseEntity.ok(productoServicio.getProducto());}

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable String id) {
        Producto encontrado = productoServicio.getProducto(id);
        if (encontrado == null) {
            return ResponseEntity.ok(encontrado);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<MessageResponse> crearProducto(
            @RequestBody Producto request){
        boolean agregado = productoServicio.agregarProducto(id, request);
        if (!agregado) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new MessageResponse("Error: producto ya existente"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageResponse("Producto agregado"));
    }
    //coment

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> actualizarProducto(
            @PathVariable String id,
            @RequestBody Producto request) {
        boolean actualizado = productoServicio.agregarProducto(id, request);
        if (!actualizado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Producto actualizado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> eliminarProducto(@PathVariable String id) {
        boolean eliminado = ProductoServicio.eliminarProducto(id);
        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Producto eliminado"));
    }


}