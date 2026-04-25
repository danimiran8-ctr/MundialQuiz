package com.mundial.app.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.mundial.app.Entidades.Club;
import com.mundial.app.Entidades.Asociacion;
import com.mundial.app.Entidades.Entrenador;
import com.mundial.app.Entidades.Competicion;
import com.mundial.app.Entidades.Jugador;
import com.mundial.app.Repositorios.ClubRepositorio;
import com.mundial.app.Repositorios.AsociacionRepositorio;
import com.mundial.app.Repositorios.EntrenadorRepositorio;
import com.mundial.app.Repositorios.JugadorRepositorio;
import com.mundial.app.Repositorios.CompeticionRepositorio;
import java.util.List;
import java.util.ArrayList;

@Controller
public class ClubWebControlador {

    @Autowired
    private ClubRepositorio clubRepositorio;
    @Autowired
    private AsociacionRepositorio asociacionRepositorio;
    @Autowired
    private EntrenadorRepositorio entrenadorRepositorio;
    @Autowired
    private JugadorRepositorio jugadorRepositorio;
    @Autowired
    private CompeticionRepositorio competicionRepositorio;

    @GetMapping({"/verClub", "/mostrarClub", "/listarClub"})
    public String listarClub(Model model) {
        List<Club> listaClub = clubRepositorio.findAll();
        model.addAttribute("listaClub", listaClub);
        return "verClub";
    }

    @GetMapping("/verClub/formClub")
    public String mostrarFormulario(Model model) {
        model.addAttribute("club", new Club());
        model.addAttribute("listaAsociacion", asociacionRepositorio.findAll());
        model.addAttribute("listaEntrenador", entrenadorRepositorio.findAll());
        model.addAttribute("listaJugador", jugadorRepositorio.findAll());
        model.addAttribute("listaCompeticion", competicionRepositorio.findAll());
        return "formClub";
    }

    @GetMapping("/verClub/editarClub/{id}")
    public String editarClub(@PathVariable String id, Model model) {
        Club club = clubRepositorio.findById(id).orElse(new Club());
        model.addAttribute("club", club);
        model.addAttribute("listaAsociacion", asociacionRepositorio.findAll());
        model.addAttribute("listaEntrenador", entrenadorRepositorio.findAll());
        model.addAttribute("listaJugador", jugadorRepositorio.findAll());
        model.addAttribute("listaCompeticion", competicionRepositorio.findAll());
        return "formClub";
    }

    @PostMapping("/verClub/guardarClub")
    public String guardarClub(
            @RequestParam(value = "id", required = false) String id,
            @RequestParam String nombre,
            @RequestParam String asociacionId,
            @RequestParam String entrenadorId,
            @RequestParam String competicionId,
            @RequestParam(value = "jugadoresIds", required = false) String[] jugadoresIds) {

        Club club = new Club();
        club.setId(id);
        club.setNombre(nombre);

        // Asociacion
        Asociacion asociacion = asociacionRepositorio.findById(asociacionId).orElse(null);
        club.setAsociacion(asociacion);

        // Entrenador
        Entrenador entrenador = entrenadorRepositorio.findById(entrenadorId).orElse(null);
        club.setEntrenador(entrenador);

        // Competicion
        List<Competicion> competiciones = new ArrayList<>();
        Competicion competicion = competicionRepositorio.findById(competicionId).orElse(null);
        if (competicion != null) competiciones.add(competicion);
        club.setCompeticiones(competiciones);

        // Jugadores con String[]
        List<Jugador> jugadores = new ArrayList<>();
        if (jugadoresIds != null && jugadoresIds.length > 0) {
            for (String jugadorId : jugadoresIds) {
                jugadorRepositorio.findById(jugadorId).ifPresent(jugadores::add);
            }
        }
        club.setJugadores(jugadores);

        clubRepositorio.save(club);
        return "redirect:/verClub";
    }

    @GetMapping("/verClub/eliminarClub/{id}")
    public String eliminarClub(@PathVariable String id) {
        clubRepositorio.deleteById(id);
        return "redirect:/verClub";
    }
}