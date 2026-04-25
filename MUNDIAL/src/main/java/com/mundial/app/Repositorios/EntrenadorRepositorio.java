package com.mundial.app.Repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.mundial.app.Entidades.Entrenador;

@Repository
public interface EntrenadorRepositorio extends MongoRepository<Entrenador, String> {
}