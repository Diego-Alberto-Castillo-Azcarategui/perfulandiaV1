package TestVenta;

import cl.duoc.perfulandia.repository.VentaRepositorio;
import cl.duoc.perfulandia.service.InventarioServicio;
import cl.duoc.perfulandia.service.VentaServicio;
import cl.duoc.perfulandia.service.dominio.Venta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TestVentaServicio {

    @Mock  VentaRepositorio ventaRepositorio;
    @Mock  InventarioServicio inventarioServicio;
    @InjectMocks  VentaServicio  ventaServicio;

    Venta venta;

    @BeforeEach
    void init() {
        venta = new Venta();
        venta.setId(5L);
        venta.setFecha(LocalDateTime.now());
        venta.setCantidad(1);
        venta.setTotal(BigDecimal.valueOf(5000));
    }

    @Test
    void listarVentas() {
        when(ventaRepositorio.findAll()).thenReturn(List.of(venta));
        assertThat(ventaServicio.listarVentas()).hasSize(1);
    }

    @Test
    void buscarVenta() {
        when(ventaRepositorio.findById(5L)).thenReturn(Optional.of(venta));
        assertThat(ventaServicio.buscar(5L)).isSameAs(venta);
    }

    @Test
    void crearVenta() {
        venta.setId(null);

        when(ventaRepositorio.save(any(Venta.class))).thenAnswer(inv -> {
            Venta v = inv.getArgument(0);
            v.setId(1L);
            return v;
        });

        Venta creada = ventaServicio.crear(venta);

        // 3) verificaciones
        assertThat(creada.getId()).isEqualTo(1L);
        verify(ventaRepositorio).save(venta);
        verify(inventarioServicio).actualizarStockPorVenta(creada);
    }

    @Test
    void eliminarVenta() {
        when(ventaRepositorio.existsById(5L)).thenReturn(true);

        assertThat(ventaServicio.eliminar(5L)).isTrue();
        verify(ventaRepositorio).deleteById(5L);
    }
}
