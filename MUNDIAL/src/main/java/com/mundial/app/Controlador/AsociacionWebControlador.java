package com.mundial.app.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.mundial.app.Entidades.Asociacion;
import com.mundial.app.Repositorios.AsociacionRepositorio;
import java.util.List;

@Controller
public class AsociacionWebControlador {

    @Autowired
    private AsociacionRepositorio asociacionRepositorio;

    @GetMapping({"/verAsociacion", "/mostrarAsociacion", "/listarAsociacion"})
    public String listarAsociacion(Model model) {
        List<Asociacion> listaAsociacion = asociacionRepositorio.findAll();
        model.addAttribute("listaAsociacion", listaAsociacion);
        return "verAsociacion";
    }

    @GetMapping("/verAsociacion/formAsociacion")
    public String mostrarFormulario(Model model) {
        model.addAttribute("asociacion", new Asociacion());
        List<Asociacion> listaAsociacion = asociacionRepositorio.findAll();
        model.addAttribute("listaAsociacion", listaAsociacion);
        return "formAsociacion";
    }

    @PostMapping("/verAsociacion/guardarAsociacion")
    public String guardarAsociacion(Asociacion asociacion) {
        asociacionRepositorio.save(asociacion);
        return "redirect:/verAsociacion";
    }

    @GetMapping("/verAsociacion/eliminarAsociacion/{id}")
    public String eliminarAsociacion(@PathVariable String id) {
        asociacionRepositorio.deleteById(id);
        return "redirect:/verAsociacion";
    }
    
    @GetMapping("/verAsociacion/editarAsociacion/{id}")
    public String editarAsociacion(@PathVariable String id, Model model) {
        Asociacion asociacion = asociacionRepositorio.findById(id).orElse(null);
        model.addAttribute("asociacion", asociacion);
        return "formAsociacion"; // reutiliza el formulario
    }
}