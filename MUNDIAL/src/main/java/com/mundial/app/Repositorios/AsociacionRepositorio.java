package com.mundial.app.Repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.mundial.app.Entidades.Asociacion;

@Repository
public interface AsociacionRepositorio extends MongoRepository<Asociacion, String> {
}