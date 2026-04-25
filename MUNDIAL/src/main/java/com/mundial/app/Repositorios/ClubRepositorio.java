package com.mundial.app.Repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.mundial.app.Entidades.Club;

@Repository
public interface ClubRepositorio extends MongoRepository<Club, String> {
}
