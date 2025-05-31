package com.appTest.veterinaria.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DuenioDTO implements Serializable{
    private String nombre;
    private String apellido;
    private Long dni;
    private Long nroCelular;
    private int cantidadMascotas;

    public DuenioDTO() {
    }

    public DuenioDTO(String nombre, String apellido, Long dni, Long nroCelular, int cantidadMascotas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nroCelular = nroCelular;
        this.cantidadMascotas = cantidadMascotas;
    }
    
    
}
