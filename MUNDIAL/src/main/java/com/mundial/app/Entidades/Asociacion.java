package com.mundial.app.Entidades;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "asociaciones")

public class Asociacion {

    @Id
    private String id;

    private String nombre;
    private String pais;
    private String presidente;
	
}
