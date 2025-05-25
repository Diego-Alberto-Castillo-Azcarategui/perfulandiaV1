package cl.duoc.perfulandia.repository;

import cl.duoc.perfulandia.service.dominio.Inventario;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InventarioRepositorio {
    private static final List<Inventario> inventarios = new ArrayList<>();

    static {
        inventarios.addAll(
                List.of(
                        Inventario.builder()
                                .id("INV001")
                                .productoId("POO1")
                                .stock(150)
                                .stockMinimo(20)
                                .ubicacion("A1-05")
                                .estado("Disponible")
                                .fechaActualizacion("2023-11-15")
                                .build(),
                        Inventario.builder()
                                .id("INV002")
                                .productoId("POO2")
                                .stock(80)
                                .stockMinimo(15)
                                .ubicacion("A1-06")
                                .estado("Disponible")
                                .fechaActualizacion("2023-11-15")
                                .build(),
                        Inventario.builder()
                                .id("INV003")
                                .productoId("P003")
                                .stock(45)
                                .stockMinimo(10)
                                .ubicacion("B2-01")
                                .estado("Stock bajo")
                                .fechaActualizacion("2023-11-15")
                                .build(),
                        Inventario.builder()
                                .id("INV004")
                                .productoId("P004")
                                .stock(0)
                                .stockMinimo(5)
                                .ubicacion("B2-02")
                                .estado("Agotado")
                                .fechaActualizacion("2023-11-10")
                                .build(),
                        Inventario.builder()
                                .id("INV005")
                                .productoId("P009")
                                .stock(30)
                                .stockMinimo(8)
                                .ubicacion("B2-03")
                                .estado("Disponible")
                                .fechaActualizacion("2023-11-14")
                                .build()
                )
        );
    }