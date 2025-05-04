package cl.duoc.perfulandia.repository;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

public class usuarioRepository {

    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private LocalDateTime fechaCreacion;
    private String direccion;


}
