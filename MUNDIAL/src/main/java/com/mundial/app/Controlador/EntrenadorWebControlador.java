package com.mundial.app.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.mundial.app.Entidades.Entrenador;
import com.mundial.app.Repositorios.EntrenadorRepositorio;
import java.util.List;

@Controller
public class EntrenadorWebControlador {

    @Autowired
    private EntrenadorRepositorio entrenadorRepositorio;

    @GetMapping({"/verEntrenador", "/mostrarEntrenador", "/listarEntrenador"})
    public String listarEntrenador(Model model) {
        List<Entrenador> listaEntrenador = entrenadorRepositorio.findAll();
        model.addAttribute("listaEntrenador", listaEntrenador);
        return "verEntrenador";
    }

    @GetMapping("/verEntrenador/formEntrenador")
    public String mostrarFormulario(Model model) {
        model.addAttribute("entrenador", new Entrenador());
        List<Entrenador> listaEntrenador = entrenadorRepositorio.findAll();
        model.addAttribute("listaEntrenador", listaEntrenador);
        return "formEntrenador";
    }

    @PostMapping("/verEntrenador/guardarEntrenador")
    public String guardarEntrenador(Entrenador entrenador) {
        entrenadorRepositorio.save(entrenador);
        return "redirect:/verEntrenador";
    }

    @GetMapping("/verEntrenador/eliminarEntrenador/{id}")
    public String eliminarEntrenador(@PathVariable String id) {
        entrenadorRepositorio.deleteById(id);
        return "redirect:/verEntrenador";
    }
    
    @GetMapping("/verEntrenador/editarEntrenador/{id}")
    public String editarEntrenador(@PathVariable String id, Model model) {
        Entrenador entrenador = entrenadorRepositorio.findById(id).orElse(null);
        model.addAttribute("entrenador", entrenador);
        return "formEntrenador";
    }
}