package com.mundial.app.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mundial.app.Entidades.Entrenador;
import com.mundial.app.Repositorios.EntrenadorRepositorio;
import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorRestControlador {

    @Autowired
    private EntrenadorRepositorio entrenadorRepositorio;

    @GetMapping
    public List<Entrenador> listar() {
        return entrenadorRepositorio.findAll();
    }

    @PostMapping
    public Entrenador guardar(@RequestBody Entrenador entrenador) {
        return entrenadorRepositorio.save(entrenador);
    }

    @PutMapping("/{id}")
    public Entrenador actualizar(@PathVariable String id, @RequestBody Entrenador entrenador) {
        entrenador.setId(id);
        return entrenadorRepositorio.save(entrenador);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        entrenadorRepositorio.deleteById(id);
    }
}
