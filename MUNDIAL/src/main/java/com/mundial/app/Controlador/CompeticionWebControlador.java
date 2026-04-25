package com.mundial.app.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.mundial.app.Entidades.Competicion;
import com.mundial.app.Repositorios.CompeticionRepositorio;
import java.util.List;

@Controller
public class CompeticionWebControlador {

    @Autowired
    private CompeticionRepositorio competicionRepositorio;

    @GetMapping({"/verCompeticion", "/mostrarCompeticion", "/listarCompeticion"})
    public String listarCompeticion(Model model) {
        List<Competicion> listaCompeticion = competicionRepositorio.findAll();
        model.addAttribute("listaCompeticion", listaCompeticion);
        return "verCompeticion";
    }

    @GetMapping("/verCompeticion/formCompeticion")
    public String mostrarFormulario(Model model) {
        model.addAttribute("competicion", new Competicion());
        List<Competicion> listaCompeticion = competicionRepositorio.findAll();
        model.addAttribute("listaCompeticion", listaCompeticion);
        return "formCompeticion";
    }

    @PostMapping("/verCompeticion/guardarCompeticion")
    public String guardarCompeticion(Competicion competicion) {
        competicionRepositorio.save(competicion);
        return "redirect:/verCompeticion";
    }

    @GetMapping("/verCompeticion/eliminarCompeticion/{id}")
    public String eliminarCompeticion(@PathVariable String id) {
        competicionRepositorio.deleteById(id);
        return "redirect:/verCompeticion";
    }
    
    @GetMapping("/verCompeticion/editarCompeticion/{id}")
    public String editarCompeticion(@PathVariable String id, Model model) {
        Competicion competicion = competicionRepositorio.findById(id).orElse(null);
        model.addAttribute("competicion", competicion);
        model.addAttribute("listaCompeticion", competicionRepositorio.findAll());
        return "formCompeticion";
    }
    
}
