package cl.duoc.perfulandia.service.dominio;


import cl.duoc.perfulandia.repository.UsuarioRepositorio;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "usuarios")
public class Usuario {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
