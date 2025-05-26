package cl.duoc.perfulandia.controller;


import cl.duoc.perfulandia.dto.MessageResponse;
import cl.duoc.perfulandia.service.VentaServicio;
import cl.duoc.perfulandia.service.dominio.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")


public class VentaControlador {
    @Autowired
    private VentaServicio ventaServicio;

    @GetMapping
    public ResponseEntity<List<Venta>> listarVentas() {
        return ResponseEntity.ok(ventaServicio.getVenta());}

    @GetMapping("/{id}")
    public ResponseEntity<Venta> buscarVentaPorId(@PathVariable String id) {
        Venta encontrado = ventaServicio.getVenta(id);
        if (encontrado != null) {
            return ResponseEntity.ok(encontrado);
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<MessageResponse> crearVenta (
            @RequestBody Venta request){
        boolean agregado = ventaServicio.agregarVenta(request);
        if (!agregado) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new MessageResponse("Error: Venta no pudo concretarse"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageResponse("Venta generada"));

    }
    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> actualizarVenta (
            @PathVariable String id,
            @RequestBody Venta request) {
        boolean actualizado = ventaServicio.actualizarVenta(id, request);
        if (!actualizado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Información de la venta actualizada"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> eliminarVenta (@PathVariable String id) {
        boolean eliminado = ventaServicio.eliminarVenta(id);
        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Venta eliminada"));

    }
}
