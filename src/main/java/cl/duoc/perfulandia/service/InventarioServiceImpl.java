package cl.duoc.perfulandia.service;

import cl.duoc.perfulandia.repository.InventarioRepositorio;
import cl.duoc.perfulandia.service.dominio.Inventario;
import cl.duoc.perfulandia.service.dominio.Producto;
import cl.duoc.perfulandia.service.dominio.Venta;
import cl.duoc.perfulandia.service.dominio.DetalleVenta;
import cl.duoc.perfulandia.service.InventarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventarioServiceImpl implements InventarioServicio {

    @Override
    public boolean eliminarInventario(String id) {
        Inventario encontrado = inventarioRepositorio.findById(id).orElse(null);
        if (encontrado == null) {
            return false;
        }
        inventarioRepositorio.delete(encontrado);
        return true;
    }


    @Override
    public boolean actualizarInventario(String id, Inventario request) {
        Inventario encontrado = inventarioRepositorio.findById(id).orElse(null);
        if (encontrado == null) {
            return false;
        }
        encontrado.setStock(request.getStock());
        inventarioRepositorio.save(encontrado);
        return true;
    }


    @Override
    public boolean agregarInventario(Inventario inventario) {
        String id = inventario.getId();
        Inventario encontrado = inventarioRepositorio.findById(id).orElse(null);
        if (encontrado != null) {
            return false;
        }
        inventarioRepositorio.save(inventario);
        return true;
    }

    @Override
    public Inventario getInventario(String id) {
        return inventarioRepositorio.findById(id).orElse(null);
    }

    @Autowired
    private InventarioRepositorio inventarioRepositorio;

    @Override
    public List<Inventario> getInventario() {
        return inventarioRepositorio.findAll();
    }

    @Override
    public void actualizarStockPorVenta(Venta venta) {
        for (DetalleVenta detalle : venta.getDetalles()) {
            Producto producto = detalle.getProducto();
            int cantidadVendida = detalle.getCantidad();

            Inventario inventario = inventarioRepositorio.findByProducto(producto)
                    .orElseThrow(() -> new RuntimeException("No hay inventario para el producto " + producto.getNombre()));

            if (inventario.getStock() < cantidadVendida) {
                throw new RuntimeException("Stock insuficiente para el producto " + producto.getNombre());
            }

            inventario.setStock(inventario.getStock() - cantidadVendida);
            inventarioRepositorio.save(inventario);

        }
    }
}

