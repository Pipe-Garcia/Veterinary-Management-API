package com.appTest.veterinaria.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MascotaDTO implements Serializable{
    private String nombre;
    private String especie;
    private String raza;
    private String color;
    private String nombreDuenio;

    public MascotaDTO() {
    }

    public MascotaDTO(String nombre, String especie, String raza, String color, String nombreDuenio) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
        this.nombreDuenio = nombreDuenio;
    }  
}
