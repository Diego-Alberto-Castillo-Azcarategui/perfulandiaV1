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
@RequiredArgsConstructor
public class VentaServicio {

    private final VentaRepositorio ventaRepositorio;
    private final InventarioServicio inventarioServicio;

    public List<Venta> listarVentas() {
        return ventaRepositorio.findAll();
    }

    public Venta buscar(Long id) {
        return ventaRepositorio.findById(id).orElse(null);
    }

    public boolean actualizar(Long id, Venta venta) {
        if (!ventaRepositorio.existsById(id)) {
            return false;
        }
        venta.setId(id);
        ventaRepositorio.save(venta);
        return true;
    }

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

        if (venta.getId() == null) {
            if (venta.getFecha() == null) {
                venta.setFecha(LocalDateTime.now());
            }

            Venta ventaGuardada = ventaRepositorio.save(venta); // INSERT


            inventarioServicio.actualizarStockPorVenta(ventaGuardada);

            return ventaGuardada;
        }

        Venta existente = ventaRepositorio.findById(venta.getId())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        existente.setCantidad(venta.getCantidad());
        existente.setTotal(venta.getTotal());
        return ventaRepositorio.save(existente); // UPDATE
    }
}

