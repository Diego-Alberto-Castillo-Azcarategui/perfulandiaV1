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
                                .id("POO1")
                                .nombre("Perfume vainilla")
                                .descripcion("Perfume con un delicioso olor a vainilla")
                                .precio("30.000")
                                .categoria("Perfumes")
                                .build()

                )
        );
    }


}
