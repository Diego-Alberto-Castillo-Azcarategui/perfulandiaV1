package cl.duoc.perfulandia.service.dominio;

import cl.duoc.perfulandia.repository.InventarioRepositorio;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Inventario {
    private String id;
    private String productoId;
    private String stock;
    private String ubicacion;
    private String estado;
    private String fechaActualizacion;
}

