package com.mundial.app.Entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "jugadores")
public class Jugador {

    @Id
    private String id;

    private String nombre;
    private String apellido;
    private int numero;
    private String posicion;
    private int edad;
    private String nacionalidad;
}