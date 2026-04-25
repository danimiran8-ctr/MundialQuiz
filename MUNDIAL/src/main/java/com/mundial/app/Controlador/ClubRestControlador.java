package com.mundial.app.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mundial.app.Entidades.Club;
import com.mundial.app.Repositorios.ClubRepositorio;
import java.util.List;

@RestController
@RequestMapping("/api/clubes")
public class ClubRestControlador {

    @Autowired
    private ClubRepositorio clubRepositorio;

    @GetMapping
    public List<Club> listar() {
        return clubRepositorio.findAll();
    }

    @PostMapping
    public Club guardar(@RequestBody Club club) {
        return clubRepositorio.save(club);
    }

    @PutMapping("/{id}")
    public Club actualizar(@PathVariable String id, @RequestBody Club club) {
        club.setId(id);
        return clubRepositorio.save(club);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        clubRepositorio.deleteById(id);
    }
}
