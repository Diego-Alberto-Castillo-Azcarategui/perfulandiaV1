package cl.duoc.perfulandia.service;

import cl.duoc.perfulandia.service.dominio.Venta;
import java.util.List;
import cl.duoc.perfulandia.service.dominio.Inventario;




public interface InventarioServicio {
    void actualizarStockPorVenta(Venta venta);
    List<Inventario> getInventario();
    Inventario getInventario(String id);
    boolean agregarInventario(Inventario inventario);
    boolean actualizarInventario(String id, Inventario inventario);
    boolean eliminarInventario(String id);


}
