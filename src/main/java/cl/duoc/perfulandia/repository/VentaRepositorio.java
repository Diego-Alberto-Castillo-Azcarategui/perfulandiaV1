package cl.duoc.perfulandia.repository;

import cl.duoc.perfulandia.service.dominio.Venta;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class VentaRepositorio {
    private static final List<Venta> ventas = new ArrayList<>();

    static {
        ventas.addAll(
                List.of(
                        Venta.builder()
                        .id("V001")
                        .fecha("2025-11-20")
                        .clienteId("01")
                        .productoId("P001")
                        .cantidad("2")
                        .total("60.000")
                        .build()
                )
        );

    }

    public static List<Venta> findAll() {return ventas;}

    public static Venta findById(String id) {
        for (Venta venta : ventas) {
            if (venta.getId().equals(id)) {
                return venta;
            }
        }
        return null;
    }

    public static void agregarVenta(Venta venta) {
        ventas.add(venta);
    }

    public static void actualizarVenta(Venta toReplace,Venta request) {
        int index = ventas.indexOf(toReplace);
        ventas.set(index, request);
    }
    public static void eliminarVenta(Venta encontrado) {ventas.remove(encontrado);}

    public static List<Venta> findAll() {
        return ventas;}
}
