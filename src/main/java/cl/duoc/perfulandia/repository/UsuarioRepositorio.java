package cl.duoc.perfulandia.repository;

import cl.duoc.perfulandia.service.dominio.Usuario;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class UsuarioRepositorio {
    private static final List<Usuario> usuarios = new ArrayList<>();

    static {
        usuarios.addAll(
                List.of(
                        Usuario.builder()
                                .nombre("Test1")
                                .apellido("prueba")
                                .email("usuarioprueba@test")
                                .telefono("999999992")
                                .id("1")
                                .build()
                )
        );

    }

    public static List<Usuario> findAll() {
        return usuarios;
    }

    public static Usuario findByid(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public static void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static void actualizarUsuario(Usuario toReplace, Usuario request) {
        int index = usuarios.indexOf(toReplace);
        usuarios.set(index, request);
    }

    public static void eliminarUsuario(Usuario encontrado) {
        usuarios.remove(encontrado);
    }
}
