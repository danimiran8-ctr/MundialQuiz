package com.mundial.app.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mundial.app.Entidades.Competicion;
import com.mundial.app.Repositorios.CompeticionRepositorio;
import java.util.List;

@RestController
@RequestMapping("/api/competiciones")
public class CompeticionRestControlador {

    @Autowired
    private CompeticionRepositorio competicionRepositorio;

    @GetMapping
    public List<Competicion> listar() {
        return competicionRepositorio.findAll();
    }

    @PostMapping
    public Competicion guardar(@RequestBody Competicion competicion) {
        return competicionRepositorio.save(competicion);
    }

    @PutMapping("/{id}")
    public Competicion actualizar(@PathVariable String id, @RequestBody Competicion competicion) {
        competicion.setId(id);
        return competicionRepositorio.save(competicion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        competicionRepositorio.deleteById(id);
    }
}
