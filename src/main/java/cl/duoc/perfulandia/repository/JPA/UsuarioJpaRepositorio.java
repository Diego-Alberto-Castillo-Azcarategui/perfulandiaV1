package cl.duoc.perfulandia.repository.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioJpaRepositorio
        extends JpaRepository<UsuarioDB, Integer> {
    List<UsuarioDB> findByEmail(String email);

}