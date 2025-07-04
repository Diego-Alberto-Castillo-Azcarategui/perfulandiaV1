package cl.duoc.perfulandia.repository;

import cl.duoc.perfulandia.service.dominio.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;


public interface VentaRepositorio extends JpaRepository<Venta, Long> {

    List<Venta> findByFechaBetween(LocalDateTime desde, LocalDateTime hasta);

}

