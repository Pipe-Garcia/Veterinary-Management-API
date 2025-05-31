package com.appTest.veterinaria.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MascotaFilterRequest implements Serializable{
    private String especie;
    private String raza;
}
