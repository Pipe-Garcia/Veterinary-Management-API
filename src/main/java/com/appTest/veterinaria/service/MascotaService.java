package com.appTest.veterinaria.service;

import com.appTest.veterinaria.dto.MascotaCreateDTO;
import com.appTest.veterinaria.dto.MascotaDTO;
import com.appTest.veterinaria.dto.MascotaUpdateDTO;
import com.appTest.veterinaria.model.Duenio;
import com.appTest.veterinaria.model.Mascota;
import com.appTest.veterinaria.repository.IDuenioRepository;
import com.appTest.veterinaria.repository.IMascotaRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService{
    
    @Autowired
    private IMascotaRepository repoMasco;
    
    @Autowired
    private IDuenioRepository repoDuenio;


    @Override
    public List<Mascota> getAllMascotas() {
        List<Mascota> listaMascotas = repoMasco.findAll();
        return listaMascotas;
    }

    @Override
    public MascotaDTO convertirMascotaADto(Mascota mascota) {
        
        String nombreDuenio = (mascota.getDuenio() != null) ? mascota.getDuenio().getNombre() : "Dueño no encontrado.";
                
        return new MascotaDTO(
                mascota.getNombre(),
                mascota.getEspecie(),
                mascota.getRaza(),
                mascota.getColor(),
                nombreDuenio
        );
    }

    @Override
    public Mascota getMascotaById(Long idMascota) {
        return repoMasco.findById(idMascota).orElse(null);
    }
    
    @Override
    public List<MascotaDTO> getMascotasPorEspecieYRaza(String especie, String raza) {
        List<Mascota> lista = repoMasco.findByEspecieAndRaza(especie, raza);
        return lista.stream()
                    .map(this::convertirMascotaADto)
                    .collect(Collectors.toList());
    }


   @Override
    public void createMascota(MascotaCreateDTO dto) {
        Mascota mascota = new Mascota();
        mascota.setNombre(dto.getNombre());
        mascota.setEspecie(dto.getEspecie());
        mascota.setRaza(dto.getRaza());
        mascota.setColor(dto.getColor());

        Duenio duenio = repoDuenio.findById(dto.getDuenioId()).orElse(null);
        mascota.setDuenio(duenio);

        repoMasco.save(mascota);
    }

    @Override
    public void updateMascota(MascotaUpdateDTO dto) {
        Mascota mascota = repoMasco.findById(dto.getIdMascota()).orElse(null);

        if (mascota != null) {
            if (dto.getNombre() != null) mascota.setNombre(dto.getNombre());
            if (dto.getEspecie() != null) mascota.setEspecie(dto.getEspecie());
            if (dto.getRaza() != null) mascota.setRaza(dto.getRaza());
            if (dto.getColor() != null) mascota.setColor(dto.getColor());

            if (dto.getDuenioId() != null) {
                Duenio duenio = repoDuenio.findById(dto.getDuenioId()).orElse(null);
                mascota.setDuenio(duenio);
            }

            repoMasco.save(mascota);
        }
    }

    @Override
    public void deleteMascotaById(Long idMascota) {
        repoMasco.deleteById(idMascota);
    }
    
}
