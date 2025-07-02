package cl.duoc.perfulandia.controller;

import cl.duoc.perfulandia.dto.MessageResponse;
import cl.duoc.perfulandia.service.VentaServicio;
import cl.duoc.perfulandia.service.dominio.Venta;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")          // ← conservamos tu URL original
@RequiredArgsConstructor
public class VentaControlador {

    private final VentaServicio ventaServicio;

    /* ───────── POST /venta ─────────────────────────────────────────────── */
    @PostMapping
    public ResponseEntity<MessageResponse> crear(@RequestBody Venta request) {
        ventaServicio.crear(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new MessageResponse("Venta generada"));
    }

    /* ───────── GET /venta/{id} ─────────────────────────────────────────── */
    @GetMapping("/{id}")
    public ResponseEntity<Venta> buscar(@PathVariable Long id) {
        Venta encontrada = ventaServicio.buscar(id);
        return (encontrada == null)
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(encontrada);
    }

    /* ───────── GET /venta ──────────────────────────────────────────────── */
    @GetMapping
    public ResponseEntity<List<Venta>> listarVentas() {
        return ResponseEntity.ok(ventaServicio.listarVentas());
    }

    /* ───────── PUT /venta/{id} ─────────────────────────────────────────── */
    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> actualizar(
            @PathVariable Long id,
            @RequestBody Venta request) {

        boolean ok = ventaServicio.actualizar(id, request);
        return ok
                ? ResponseEntity.ok(new MessageResponse("Información de la venta actualizada"))
                : ResponseEntity.notFound().build();
    }

    /* ───────── DELETE /venta/{id} ──────────────────────────────────────── */
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> eliminar(@PathVariable Long id) {
        boolean ok = ventaServicio.eliminar(id);
        return ok
                ? ResponseEntity.ok(new MessageResponse("Venta eliminada"))
                : ResponseEntity.notFound().build();
    }
}
