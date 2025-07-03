package TestProducto;

import cl.duoc.perfulandia.repository.ProductoRepositorio;
import cl.duoc.perfulandia.service.ProductoServicio;
import cl.duoc.perfulandia.service.dominio.Producto;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class TestProductoServicio {

    private final ProductoServicio servicio = new ProductoServicio();
    private MockedStatic<ProductoRepositorio> repoMock;

    Producto p1;

    @BeforeEach
    void init() {
        repoMock = mockStatic(ProductoRepositorio.class);

        p1 = new Producto();
        p1.setId(1L);
        p1.setNombre("Chocolate");
        p1.setPrecio(3500.0);
    }

    @AfterEach
    void close() { repoMock.close(); }

    @Test
    void listarProductos() {
        repoMock.when(ProductoRepositorio::findAll).thenReturn(List.of(p1));
        assertThat(servicio.getProducto()).hasSize(1);
    }

    @Test
    void buscarProducto() {
        repoMock.when(() -> ProductoRepositorio.findById(1L)).thenReturn(p1);
        assertThat(servicio.getProducto(1L)).isSameAs(p1);
    }

    @Test
    void agregarProducto() {
        repoMock.when(() -> ProductoRepositorio.findById(2L)).thenReturn(null);

        Producto nuevo = new Producto(); nuevo.setId(2L);
        assertThat(servicio.agregarProducto(nuevo)).isTrue();
        repoMock.verify(() -> ProductoRepositorio.agregarProducto(nuevo));
    }

    @Test
    void eliminarProducto() {
        repoMock.when(() -> ProductoRepositorio.findById(1L)).thenReturn(p1);
        assertThat(servicio.eliminarProducto(1L)).isTrue();
        repoMock.verify(() -> ProductoRepositorio.eliminarProducto(p1));
    }
}
