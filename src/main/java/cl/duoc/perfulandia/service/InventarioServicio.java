package cl.duoc.perfulandia.service;


import cl.duoc.perfulandia.repository.InventarioRepositorio;
import cl.duoc.perfulandia.service.dominio.Inventario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioServicio {

    public static boolean eliminarInventario(String id) {
        Inventario encontrado = InventarioRepositorio.findById(id);
        if (encontrado == null) {
            return false;
        }
        InventarioRepositorio.eliminarInventario(encontrado);
        return true;
    }

    public static List <Inventario> getInventario() {
        return InventarioRepositorio.findAll();
    }


    public Inventario getInventario(String id) {
        return InventarioRepositorio.findById(id);}

    public boolean agregarInventario(Inventario inventario) {
        String id = inventario.getId();
        Inventario encontrado = InventarioRepositorio.findById(id);
        if (encontrado != null) {
            return false;
        }
        InventarioRepositorio.agregarInventario(inventario);
            return true;
    }

    public boolean actualizarInventario(String id, Inventario request) {
        Inventario encontrado = InventarioRepositorio.findById(id);
        if (encontrado == null) {
            return false;
        }
        InventarioRepositorio.actualizarInventario(encontrado,request);
            return true;
    }

}
