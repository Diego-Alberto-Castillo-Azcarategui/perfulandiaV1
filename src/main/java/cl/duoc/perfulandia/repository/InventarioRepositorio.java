package cl.duoc.perfulandia.repository;

import cl.duoc.perfulandia.service.dominio.Inventario;
import cl.duoc.perfulandia.service.dominio.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventarioRepositorio extends JpaRepository<Inventario, String> {
    Optional<Inventario> findByProducto(Producto producto);
}

