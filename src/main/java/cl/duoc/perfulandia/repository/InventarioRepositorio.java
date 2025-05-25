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
                                .stock("150")
                                .ubicacion("A1-05")
                                .estado("Disponible")
                                .fechaActualizacion("07-05-2025")
                                .build(),
                        Inventario.builder()
                                .id("INV002")
                                .productoId("POO2")
                                .stock("80")
                                .ubicacion("A1-06")
                                .estado("Disponible")
                                .fechaActualizacion("03-05-2025")
                                .build(),
                        Inventario.builder()
                                .id("INV003")
                                .productoId("P003")
                                .stock("10")
                                .ubicacion("B2-01")
                                .estado("Stock bajo")
                                .fechaActualizacion("02-05-2025")
                                .build(),
                        Inventario.builder()
                                .id("INV004")
                                .productoId("P004")
                                .stock("0")
                                .ubicacion("B2-02")
                                .estado("Agotado")
                                .fechaActualizacion("12-05-2025")
                                .build(),
                        Inventario.builder()
                                .id("INV005")
                                .productoId("P009")
                                .stock("30")
                                .ubicacion("B2-03")
                                .estado("Disponible")
                                .fechaActualizacion("21-05-2025")
                                .build()
                )
        );
    }

    public static List<Inventario> findAll() {
        return inventarios;
    }

    public static Inventario findById(String id) {
        for (Inventario inventario : inventarios) {
            if (inventario.getId().equals(id)) {
                return inventario;
            }
        }
        return null;
    }

    public static void agregarInventario(Inventario inventario) {
        inventarios.add(inventario);
    }

    public static void actualizarInventario(Inventario toReplace, Inventario request) {
        int index = inventarios.indexOf(toReplace);
        inventarios.set(index, request);

    }

    public static void eliminarInventario(Inventario encontrado) {
        inventarios.remove(encontrado);
    }
}
