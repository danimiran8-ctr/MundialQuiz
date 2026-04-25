package com.mundial.app.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mundial.app.Entidades.Asociacion;
import com.mundial.app.Repositorios.AsociacionRepositorio;
import java.util.List;

@RestController
@RequestMapping("/api/asociaciones")
public class AsociacionRestControlador {

    @Autowired
    private AsociacionRepositorio asociacionRepositorio;

    @GetMapping
    public List<Asociacion> listar() {
        return asociacionRepositorio.findAll();
    }

    @PostMapping
    public Asociacion guardar(@RequestBody Asociacion asociacion) {
        return asociacionRepositorio.save(asociacion);
    }

    @PutMapping("/{id}")
    public Asociacion actualizar(@PathVariable String id, @RequestBody Asociacion asociacion) {
        asociacion.setId(id);
        return asociacionRepositorio.save(asociacion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        asociacionRepositorio.deleteById(id);
    }
}
