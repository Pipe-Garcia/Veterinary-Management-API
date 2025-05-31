package com.appTest.veterinaria.service;

import com.appTest.veterinaria.dto.DuenioCreateDTO;
import com.appTest.veterinaria.dto.DuenioDTO;
import com.appTest.veterinaria.dto.DuenioDetalleDTO;
import com.appTest.veterinaria.dto.DuenioUpdateDTO;
import com.appTest.veterinaria.model.Duenio;
import java.util.List;


public interface IDuenioService {
    public List<Duenio> getAllDuenios();
    
    public DuenioDTO convertirDuenioADto(Duenio duenio);
    
    public Duenio getDuenioById(Long idDuenio);
    
    public DuenioDetalleDTO convertirADuenioDetalleDTO(Duenio duenio);
    
    public void deleteDuenioById(Long idDuenio);
    
    public void createDuenio(DuenioCreateDTO dto);
    
    public void updateDuenio(DuenioUpdateDTO dto);
}
