package com.mundial.app.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.mundial.app.Entidades.Jugador;
import com.mundial.app.Repositorios.JugadorRepositorio;
import java.util.List;

@Controller
public class JugadorWebControlador {

    @Autowired
    private JugadorRepositorio jugadorRepositorio;

    @GetMapping({"/verJugador", "/mostrarJugador", "/listarJugador"})
    public String listarJugador(Model model) {
        List<Jugador> listaJugador = jugadorRepositorio.findAll();
        model.addAttribute("listaJugador", listaJugador);
        return "verJugador";
    }

    @GetMapping("/verJugador/formJugador")
    public String mostrarFormulario(Model model) {
        model.addAttribute("jugador", new Jugador());
        List<Jugador> listaJugador = jugadorRepositorio.findAll();
        model.addAttribute("listaJugador", listaJugador);
        return "formJugador";
    }
   

    @PostMapping("/verJugador/guardarJugador")
    public String guardarJugador(Jugador jugador) {
        jugadorRepositorio.save(jugador);
        return "redirect:/verJugador";
    }

    @GetMapping("/verJugador/eliminarJugador/{id}")
    public String eliminarJugador(@PathVariable String id) {
        jugadorRepositorio.deleteById(id);
        return "redirect:/verJugador";
    }
    
    @GetMapping("/verJugador/editarJugador/{id}")
    public String editarJugador(@PathVariable String id, Model model) {
        Jugador jugador = jugadorRepositorio.findById(id).orElse(null);
        model.addAttribute("jugador", jugador);
        return "formJugador"; // reutiliza el mismo formulario
    }
}
