package cl.duoc.perfulandia.service.dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventario {

    @Id
    private String id;

    private Integer stock;

    @OneToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;
}

