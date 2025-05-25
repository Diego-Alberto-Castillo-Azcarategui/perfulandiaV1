package cl.duoc.perfulandia.service;

import cl.duoc.perfulandia.repository.ProductoRepositorio;
import cl.duoc.perfulandia.repository.UsuarioRepositorio;
import cl.duoc.perfulandia.service.dominio.Producto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoServicio {


    public static boolean eliminarProducto(String id) {
        Producto encontrado = ProductoRepositorio.findById(id);
        if (encontrado == null) {
            return false;
        }
        ProductoRepositorio.eliminarProducto(encontrado);
        return true;
    }

    public List<Producto> getProducto() {
        return ProductoRepositorio.findAll();
    }

    public Producto getProducto(String id) {
        return ProductoRepositorio.findById(id);
    }

    public boolean agregarProducto(Producto producto) {
        String id = producto.getId();
        Producto encontrado = ProductoRepositorio.findById(id);
        if (encontrado != null) {
            return false;
        }
        ProductoRepositorio.agregarProducto(producto);
            return true;
    }

    public boolean actualizarProducto(String id, Producto request) {
        Producto encontrado = ProductoRepositorio.findById(id);
        if (encontrado == null) {
            return false;
        }
        ProductoRepositorio.actualizarProducto(encontrado,request);
            return true;
    }
}
