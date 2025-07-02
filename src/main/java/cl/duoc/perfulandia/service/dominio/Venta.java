package cl.duoc.perfulandia.service.dominio;

import cl.duoc.perfulandia.repository.VentaRepositorio;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity @Table(name = "ventas")

public class Venta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDateTime fecha;
    @JoinColumn(name = "cliente_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario cliente;
    private int cantidad;
    private BigDecimal total;
    @OneToMany(mappedBy = "venta",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<DetalleVenta> detalles = new ArrayList<>();


}