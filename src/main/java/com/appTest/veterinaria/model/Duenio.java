package com.appTest.veterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Duenio {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDuenio;
    private String nombre;
    private String apellido;
    private Long dni;
    private Long nroCelular;

    @OneToMany(mappedBy="duenio")
    private List<Mascota> listaMascotas;
    
    public Duenio() {
    }

    public Duenio(Long idDuenio, String nombre, String apellido, Long dni, Long nroCelular, List<Mascota> listaMascotas) {
        this.idDuenio = idDuenio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nroCelular = nroCelular;
        this.listaMascotas = listaMascotas;
    }
     
}
