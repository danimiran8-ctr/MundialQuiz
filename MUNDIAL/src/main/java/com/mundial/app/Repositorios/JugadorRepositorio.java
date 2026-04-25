package com.mundial.app.Repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.mundial.app.Entidades.Jugador;

@Repository
public interface JugadorRepositorio extends MongoRepository<Jugador, String> {
}