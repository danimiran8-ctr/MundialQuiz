package com.mundial.app.Entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import lombok.Data;
import java.util.List;

@Data
@Document(collection = "clubes")

public class Club {

    @Id
    private String id;

    private String nombre;

    @DBRef
    private Entrenador entrenador;

    @DBRef
    private List<Jugador> jugadores;

    @DBRef
    private Asociacion asociacion;

    @DBRef
    private List<Competicion> competiciones;
}
