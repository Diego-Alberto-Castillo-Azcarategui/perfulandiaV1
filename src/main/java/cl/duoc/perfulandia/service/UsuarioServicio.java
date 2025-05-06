package cl.duoc.perfulandia.service;

import cl.duoc.perfulandia.model.Usuario;
import java.util.List;

public interface UsuarioServicio {
    List<Usuario> obtenerUsuarios();
    Usuario getUsuario(String id);
    boolean agregarUsuario(Usuario usuario);
    boolean reemplazarUsuario(String id, Usuario usuario);
    boolean eliminarUsuario(String id);
}
