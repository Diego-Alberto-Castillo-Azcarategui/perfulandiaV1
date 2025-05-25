package cl.duoc.perfulandia.service;

import cl.duoc.perfulandia.repository.ProductoRepositorio;
import cl.duoc.perfulandia.repository.UsuarioRepositorio;
import cl.duoc.perfulandia.service.dominio.Producto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoServicio {


    public static boolean eliminarProducto(String id) {
    }

    public List<Producto> getProducto() {
        return ProductoRepositorio.finAll();
    }

    public Producto getProducto(String id) {
        return null;
    }

    public boolean agregarProducto(String id, Producto request) {
    }
}
