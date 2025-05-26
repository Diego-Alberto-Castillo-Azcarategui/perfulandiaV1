package cl.duoc.perfulandia.service.dominio;

import cl.duoc.perfulandia.repository.VentaRepositorio;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Venta {
    private String id;
    private String fecha;
    private String clienteId;
    private String productoId;
    private String cantidad;
    private String total;
}
