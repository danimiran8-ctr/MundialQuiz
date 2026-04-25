package com.mundial.app.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mundial.app.Entidades.Jugador;
import com.mundial.app.Repositorios.JugadorRepositorio;
import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorRestControlador {

    @Autowired
    private JugadorRepositorio jugadorRepositorio;

    @GetMapping
    public List<Jugador> listar() {
        return jugadorRepositorio.findAll();
    }

    @PostMapping
    public Jugador guardar(@RequestBody Jugador jugador) {
        return jugadorRepositorio.save(jugador);
    }

    @PutMapping("/{id}")
    public Jugador actualizar(@PathVariable String id, @RequestBody Jugador jugador) {
        jugador.setId(id); 
        return jugadorRepositorio.save(jugador);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        jugadorRepositorio.deleteById(id);
    }
}