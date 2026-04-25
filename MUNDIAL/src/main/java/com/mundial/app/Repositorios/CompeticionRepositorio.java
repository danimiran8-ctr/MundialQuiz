package com.mundial.app.Repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.mundial.app.Entidades.Competicion;

@Repository
public interface CompeticionRepositorio extends MongoRepository<Competicion, String> {
}
