package com.appTest.veterinaria.service;

import com.appTest.veterinaria.dto.MascotaCreateDTO;
import com.appTest.veterinaria.dto.MascotaDTO;
import com.appTest.veterinaria.dto.MascotaUpdateDTO;
import com.appTest.veterinaria.model.Mascota;
import java.util.List;


public interface IMascotaService {
    public List<Mascota> getAllMascotas();
     
    public MascotaDTO convertirMascotaADto(Mascota mascota);
    
    public Mascota getMascotaById(Long idMascota);
     
    public void createMascota(MascotaCreateDTO dto);
    
    public void updateMascota(MascotaUpdateDTO dto);
    
    public void deleteMascotaById(Long idMascota);
    
    List<MascotaDTO> getMascotasPorEspecieYRaza(String especie, String raza);

}
