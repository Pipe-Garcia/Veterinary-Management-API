package com.appTest.veterinaria.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DuenioCreateDTO implements Serializable{
    private String nombre;
    private String apellido;
    private Long dni;
    private Long nroCelular;
}
