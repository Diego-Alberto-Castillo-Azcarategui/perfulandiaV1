package cl.duoc.perfulandia.service;

import cl.duoc.perfulandia.repository.VentaRepositorio;
import cl.duoc.perfulandia.service.dominio.Venta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class VentaServicio {

    public static boolean eliminarVenta(String id) {
        Venta encontrado = VentaRepositorio.findById(id);
        if (encontrado == null) {
            return false;
        }
        VentaRepositorio.eliminarVenta(encontrado);
        return true;
    }

    public List<Venta> getVenta() {return VentaRepositorio.findAll(); }

    public boolean agregarVenta(Venta venta) {
        String id = venta.getId();
        Venta encontrado = VentaRepositorio.findById(id);
        if (encontrado != null) {
            return false;
        }
        VentaRepositorio.agregarVenta(venta);
            return true;

    }

    public boolean actualizarVenta(String id, Venta request) {
        Venta encontrado = VentaRepositorio.findById(id);
        if (encontrado == null) {
            return false;
        }
        VentaRepositorio.actualizarVenta(encontrado, request);
            return true;
    }


}
