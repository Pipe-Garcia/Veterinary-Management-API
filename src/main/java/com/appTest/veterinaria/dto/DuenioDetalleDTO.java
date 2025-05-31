package com.appTest.veterinaria.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DuenioDetalleDTO implements Serializable{
    private String nombreMascota;
    private String especie;
    private String raza;
    private String nombreDuenio;
    private String apellidoDuenio;

    public DuenioDetalleDTO() {
    }

    public DuenioDetalleDTO(String nombreMascota, String especie, String raza, String nombreDuenio, String apellidoDuenio) {
        this.nombreMascota = nombreMascota;
        this.especie = especie;
        this.raza = raza;
        this.nombreDuenio = nombreDuenio;
        this.apellidoDuenio = apellidoDuenio;
    }
      
}
