package cl.duoc.perfulandia.service;

import cl.duoc.perfulandia.repository.VentaRepositorio;
import cl.duoc.perfulandia.service.dominio.Venta;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor          // ← genera el constructor con el repo
public class VentaServicio {

    private final VentaRepositorio ventaRepositorio;

    /* ───────── CRUD básico ─────────────────────────────────────────────── */


    public List<Venta> listarVentas() {
        return ventaRepositorio.findAll();
    }

    public Venta buscar(Long id) {
        return ventaRepositorio.findById(id).orElse(null);
    }

    /** @return true si la venta existía y se actualizó */
    public boolean actualizar(Long id, Venta venta) {
        if (!ventaRepositorio.existsById(id)) {
            return false;
        }
        venta.setId(id);                  // asegúrate de tener setId(...)
        ventaRepositorio.save(venta);
        return true;
    }

    /** @return true si la venta existía y se eliminó */
    public boolean eliminar(Long id) {
        if (!ventaRepositorio.existsById(id)) {
            return false;
        }
        ventaRepositorio.deleteById(id);
        return true;
    }

    @SneakyThrows
    @Transactional
    public Venta crear(Venta venta) {
        // si llega con ID nulo ⇒ nueva venta
        if (venta.getId() == null) {
            if (venta.getFecha() == null) {
                venta.setFecha(LocalDateTime.now());
            }
            return ventaRepositorio.save(venta);   // INSERT
        }
        // si llega con ID ⇒ validar que exista (UPDATE) o lanzar 404
        Venta existente = ventaRepositorio.findById(venta.getId())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        // copiar campos y guardar
        existente.setCantidad(venta.getCantidad());
        existente.setTotal(venta.getTotal());
        return ventaRepositorio.save(existente);   // UPDATE
    }
}
