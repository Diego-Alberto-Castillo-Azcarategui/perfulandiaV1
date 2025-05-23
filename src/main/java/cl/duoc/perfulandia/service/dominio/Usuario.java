package cl.duoc.perfulandia.service.dominio;


import cl.duoc.perfulandia.repository.UsuarioRepositorio;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String id;

}
