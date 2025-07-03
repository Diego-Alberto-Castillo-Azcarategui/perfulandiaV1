package cl.duoc.perfulandia.repository;

import cl.duoc.perfulandia.service.dominio.Producto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductoRepositorio {

    private static final List<Producto> productos = new ArrayList<>();

    static {
        productos.addAll(List.of(
                Producto.builder()
                        .id(1L)
                        .nombre("Perfume vainilla")
                        .descripcion("Perfume con un delicioso olor a vainilla")
                        .precio(30000.0)
                        .categoria("Perfumes")
                        .build(),
                Producto.builder()
                        .id(2L)
                        .nombre("Perfume Ben 10")
                        .descripcion("Perfume con olor a limón")
                        .precio(10000.0)
                        .categoria("Perfumes")
                        .build(),
                Producto.builder()
                        .id(3L)
                        .nombre("Essence Mystique")
                        .descripcion("Perfume floral con notas de jazmín y vainilla")
                        .precio(59900.0)
                        .categoria("Perfumes")
                        .build(),
                Producto.builder()
                        .id(4L)
                        .nombre("Ocean Breeze")
                        .descripcion("Fragancia fresca con notas cítricas y acuáticas")
                        .precio(49750.0)
                        .categoria("Perfumes")
                        .build(),
                Producto.builder()
                        .id(5L)
                        .nombre("Noir Élégance")
                        .descripcion("Perfume oriental con ámbar y sándalo")
                        .precio(68400.0)
                        .categoria("Perfumes")
                        .build()
        ));
    }

    public static List<Producto> findAll() { return productos; }

    public static Producto findById(Long id) {
        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static void agregarProducto(Producto producto) { productos.add(producto); }

    public static void actualizarProducto(Producto viejo, Producto nuevo) {
        productos.set(productos.indexOf(viejo), nuevo);
    }

    public static void eliminarProducto(Producto p) { productos.remove(p); }
}
