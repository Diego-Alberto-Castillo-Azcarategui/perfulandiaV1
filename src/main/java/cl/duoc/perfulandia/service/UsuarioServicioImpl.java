package cl.duoc.perfulandia.service;

import cl.duoc.perfulandia.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private final List<Usuario> usuarios = new ArrayList<>();

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    @Override
    public Usuario getUsuario(String id) {
        return usuarios.stream()
                .filter(u -> id != null && id.equals(u.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean agregarUsuario(Usuario usuario) {
        if (usuarios.stream().anyMatch(u ->
                (usuario.getId() != null && usuario.getId().equals(u.getId())) ||
                        (usuario.getCorreo() != null && usuario.getCorreo().equals(u.getCorreo())))) {
            return false;
        }
        usuarios.add(usuario);
        return true;
    }

    @Override
    public boolean reemplazarUsuario(String id, Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (id != null && id.equals(usuarios.get(i).getId())) {
                usuario.setId(id);
                usuarios.set(i, usuario);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminarUsuario(String id) {
        return usuarios.removeIf(u -> id != null && id.equals(u.getId()));
    }
}
