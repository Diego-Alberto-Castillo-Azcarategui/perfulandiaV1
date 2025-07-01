package cl.duoc.perfulandia.repository.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductoJpaRepositorio
    extends JpaRepository<ProductoDB, Integer> {
        List<ProductoDB> findById(Long id);

}