package cl.duoc.perfulandia.service.dominio;

import cl.duoc.perfulandia.repository.ProductoRepositorio;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Producto {
    private String id;
    private String nombre;
    private String descripcion;
    private String precio;
    private String categoria;
}
