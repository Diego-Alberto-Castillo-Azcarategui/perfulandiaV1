package TestInventario;

import cl.duoc.perfulandia.repository.InventarioRepositorio;
import cl.duoc.perfulandia.service.InventarioServiceImpl;
import cl.duoc.perfulandia.service.dominio.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TestInventarioServicio {

    @Mock  InventarioRepositorio inventarioRepositorio;
    @InjectMocks  InventarioServiceImpl inventarioSvc;

    Inventario inv;

    @BeforeEach
    void init() {
        Producto prod = new Producto(); prod.setId(10L); prod.setNombre("Perfume");
        inv = new Inventario(); inv.setId("I001"); inv.setStock(10); inv.setProducto(prod);
    }

    @Test
    void listarInventario() {
        when(inventarioRepositorio.findAll()).thenReturn(List.of(inv));
        assertThat(inventarioSvc.getInventario()).hasSize(1);
    }

    @Test
    void buscarInventario() {
        when(inventarioRepositorio.findById("I001")).thenReturn(Optional.of(inv));
        assertThat(inventarioSvc.getInventario("I001")).isSameAs(inv);
    }

    @Test
    void agregarInventario() {
        when(inventarioRepositorio.findById("I001")).thenReturn(Optional.empty());

        boolean ok = inventarioSvc.agregarInventario(inv);

        assertThat(ok).isTrue();
        verify(inventarioRepositorio).save(inv);
    }

    @Test
    void agregarInventarioDuplicado() {
        when(inventarioRepositorio.findById("I001")).thenReturn(Optional.of(inv));

        boolean ok = inventarioSvc.agregarInventario(inv);

        assertThat(ok).isFalse();
        verify(inventarioRepositorio, never()).save(any());
    }

    @Test
    void actualizarInventario() {
        when(inventarioRepositorio.findById("I001")).thenReturn(Optional.of(inv));

        Inventario req = new Inventario(); req.setStock(5);
        boolean ok = inventarioSvc.actualizarInventario("I001", req);

        assertThat(ok).isTrue();
        assertThat(inv.getStock()).isEqualTo(5);
        verify(inventarioRepositorio).save(inv);
    }

    @Test
    void eliminarInventario() {
        when(inventarioRepositorio.findById("I002")).thenReturn(Optional.empty());
        boolean ok = inventarioSvc.eliminarInventario("I002");
        assertThat(ok).isFalse();
    }

    @Test
    void actualizarStockPorVenta() {
        DetalleVenta det = new DetalleVenta();
        det.setProducto(inv.getProducto());
        det.setCantidad(3);

        Venta venta = new Venta();
        venta.setDetalles(List.of(det));

        when(inventarioRepositorio.findByProducto(inv.getProducto()))
                .thenReturn(Optional.of(inv));

        inventarioSvc.actualizarStockPorVenta(venta);

        assertThat(inv.getStock()).isEqualTo(7);
        verify(inventarioRepositorio).save(inv);
    }
}
