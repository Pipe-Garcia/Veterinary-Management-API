package com.appTest.veterinaria.controller;

import com.appTest.veterinaria.dto.MascotaCreateDTO;
import com.appTest.veterinaria.dto.MascotaDTO;
import com.appTest.veterinaria.dto.MascotaFilterRequest;
import com.appTest.veterinaria.dto.MascotaUpdateDTO;
import com.appTest.veterinaria.model.Mascota;
import com.appTest.veterinaria.service.IMascotaService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/mascotas")
public class MascotaController {
    
    @Autowired
    private IMascotaService servMasco;
    
    
    @GetMapping
    public ResponseEntity<List<MascotaDTO>> getAllMascotas() {
        
        List<Mascota> listaMascotas = servMasco.getAllMascotas();
                
        List<MascotaDTO> listaMascotasDTO = listaMascotas.stream()
                                            .map(m -> servMasco.convertirMascotaADto(m))
                                            .collect(Collectors.toList());
        
        return ResponseEntity.ok(listaMascotasDTO);
    }
    
    @GetMapping ("/{id}")
    public ResponseEntity<MascotaDTO> getMascotaById(@PathVariable Long id) {
        
        Mascota mascota = servMasco.getMascotaById(id);
        
        if (mascota == null) {
            return ResponseEntity.notFound().build();
        }
        
        MascotaDTO mascotaDTO = servMasco.convertirMascotaADto(mascota);
        
        return ResponseEntity.ok(mascotaDTO);
    }
    
    @PostMapping("/filtrar")
    public ResponseEntity<List<MascotaDTO>> getMascotasFiltradas(@RequestBody MascotaFilterRequest filtro) {

        List<MascotaDTO> lista = servMasco.getMascotasPorEspecieYRaza(
            filtro.getEspecie(),
            filtro.getRaza()
        );

        return ResponseEntity.ok(lista);
    }

    
    @PostMapping ("/create")
    public ResponseEntity<String> createMascota(@RequestBody MascotaCreateDTO dto) {
        
        servMasco.createMascota(dto);
        
        return ResponseEntity.status(HttpStatus.CREATED).body("Mascota creada correctamente");
    }
    
    @PutMapping ("/update")
    public ResponseEntity<String> updateMascota(@RequestBody MascotaUpdateDTO dto) {
        
        servMasco.updateMascota(dto);
        
        return ResponseEntity.ok("Mascota actualizada correctamente");
    }
    
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteMascotaById(@PathVariable Long id) {
        
        Mascota mascota = servMasco.getMascotaById(id);
        
        if (mascota != null) {
            servMasco.deleteMascotaById(id);
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.notFound().build();
    }
}
