package com.appTest.veterinaria.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MascotaUpdateDTO implements Serializable{
    private Long idMascota;
    private String nombre;
    private String especie;
    private String raza;
    private String color;
    private Long duenioId;
}
