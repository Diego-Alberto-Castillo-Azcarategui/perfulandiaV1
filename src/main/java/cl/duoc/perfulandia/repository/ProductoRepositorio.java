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
        productos.addAll(
                List.of(
                        Producto.builder()
                                .id(Long.valueOf("P001"))
                                .nombre("Perfume vainilla")
                                .descripcion("Perfume con un delicioso olor a vainilla")
                                .precio(Double.valueOf("30.000"))
                                .categoria("Perfumes")
                                .build(),
                        Producto.builder()
                                .id(Long.valueOf("P002"))
                                .nombre("Perfume Ben 10")
                                .descripcion("Perfume con olor a limon")
                                .precio(Double.valueOf("10.000"))
                                .categoria("Perfumes")
                                .build(),
                        Producto.builder()
                                .id(Long.valueOf("P003"))
                                .nombre("Essence Mystique")
                                .descripcion("Perfume floral con notas de jazmín y vainilla")
                                .precio(Double.valueOf("59.900"))
                                .categoria("Perfumes")
                                .build(),
                        Producto.builder()
                                .id(Long.valueOf("P004"))
                                .nombre("Ocean Breeze")
                                .descripcion("Fragancia fresca con notas cítricas y acuáticas")
                                .precio(Double.valueOf("49.750"))
                                .categoria("Perfumes")
                                .build(),
                        Producto.builder()
                                .id(Long.valueOf("P009"))
                                .nombre("Noir Élégance")
                                .descripcion("Perfume oriental con notas de ámbar y madera de sándalo, para la noche")
                                .precio(Double.valueOf("68.400"))
                                .categoria("Perfumes")
                                .build()

                )
        );
    }
    public static List<Producto> findAll() {return productos;}

    public static Producto findById(Long id) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    public static void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public static void actualizarProducto(Producto toReplace, Producto request) {
        int index = productos.indexOf(toReplace);
        productos.set(index,request);
    }

    public static void eliminarProducto(Producto encontrado){ productos.remove(encontrado);}

    public static List<Producto> finAll() {
        return productos;
    }
}
