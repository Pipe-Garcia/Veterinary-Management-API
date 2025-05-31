package com.appTest.veterinaria.service;

import com.appTest.veterinaria.dto.DuenioCreateDTO;
import com.appTest.veterinaria.dto.DuenioDTO;
import com.appTest.veterinaria.dto.DuenioDetalleDTO;
import com.appTest.veterinaria.dto.DuenioUpdateDTO;
import com.appTest.veterinaria.model.Duenio;
import com.appTest.veterinaria.model.Mascota;
import com.appTest.veterinaria.repository.IDuenioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class DuenioService implements IDuenioService{
    
    @Autowired
    private IDuenioRepository repoDuenio;

    @Autowired
    @Lazy
    private IMascotaService servMasco;
    
    @Override
    public List<Duenio> getAllDuenios() {
        List<Duenio> listaDuenios = repoDuenio.findAll();
        return listaDuenios;
    }

    @Override
    public DuenioDTO convertirDuenioADto(Duenio duenio) {
        int cantidadMascotas = (duenio.getListaMascotas() != null) ? duenio.getListaMascotas().size() : 0;
        
        return new DuenioDTO (
                duenio.getNombre(),
                duenio.getApellido(),
                duenio.getDni(),
                duenio.getNroCelular(),
                cantidadMascotas
            );    
    }
    
    @Override
    public Duenio getDuenioById(Long idDuenio) {
        return repoDuenio.findById(idDuenio).orElse(null);
    }

    @Override
    public DuenioDetalleDTO convertirADuenioDetalleDTO(Duenio duenio) {
        if (duenio.getListaMascotas() == null || duenio.getListaMascotas().isEmpty()) {
            return null;
        }

        Mascota mascota = duenio.getListaMascotas().get(0); // solo la primera, o podés usar un loop si querés todas

        return new DuenioDetalleDTO(
            mascota.getNombre(),
            mascota.getEspecie(),
            mascota.getRaza(),
            duenio.getNombre(),
            duenio.getApellido()
        );
    }

    
    @Override
    public void deleteDuenioById(Long idDuenio) {
        repoDuenio.deleteById(idDuenio);
    }

    @Override
    public void createDuenio(DuenioCreateDTO dto) {
        Duenio duenio = new Duenio();
        duenio.setNombre(dto.getNombre());
        duenio.setApellido(dto.getApellido());
        duenio.setDni(dto.getDni());
        duenio.setNroCelular(dto.getNroCelular());
        
        repoDuenio.save(duenio);
    }

    @Override
    public void updateDuenio(DuenioUpdateDTO dto) {
        Duenio duenio = repoDuenio.findById(dto.getIdDuenio()).orElse(null);
        
        if (duenio != null) {
            if (dto.getNombre() != null) duenio.setNombre(dto.getNombre());
            if (dto.getApellido() != null) duenio.setApellido(dto.getApellido());
            if (dto.getDni() != null) duenio.setDni(dto.getDni());
            if (dto.getNroCelular() != null) duenio.setNroCelular(dto.getNroCelular());
            
            repoDuenio.save(duenio);
        }
    }
    
}
