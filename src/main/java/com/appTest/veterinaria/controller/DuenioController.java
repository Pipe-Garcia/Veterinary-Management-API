package com.appTest.veterinaria.controller;

import com.appTest.veterinaria.dto.DuenioCreateDTO;
import com.appTest.veterinaria.dto.DuenioDTO;
import com.appTest.veterinaria.dto.DuenioDetalleDTO;
import com.appTest.veterinaria.dto.DuenioUpdateDTO;
import com.appTest.veterinaria.model.Duenio;
import com.appTest.veterinaria.service.IDuenioService;
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
@RequestMapping ("/duenios")
public class DuenioController {
    
    @Autowired
    private IDuenioService servDuenio;
    
    
    @GetMapping
    public ResponseEntity<List<DuenioDTO>> getAllDuenios() {
        
        List<Duenio> listaDuenios = servDuenio.getAllDuenios();
        
        List<DuenioDTO> listaDueniosDTO = listaDuenios.stream()
                                          .map(d -> servDuenio.convertirDuenioADto(d))
                                          .collect(Collectors.toList());
        
        return ResponseEntity.ok(listaDueniosDTO);
    }
    
    @GetMapping ("/{idDuenio}")
    public ResponseEntity<DuenioDTO> getDuenioById(@PathVariable Long idDuenio) {
        
        Duenio duenio = servDuenio.getDuenioById(idDuenio);
        
        if (duenio == null) {
            return ResponseEntity.notFound().build();
        }
        
        DuenioDTO duenioDTO = servDuenio.convertirDuenioADto(duenio);
        
        return ResponseEntity.ok(duenioDTO);
    }
    
    @GetMapping ("/{idDuenio}/detalle")
    public ResponseEntity<DuenioDetalleDTO> getDuenioDetalle(@PathVariable Long idDuenio) {
        
        Duenio duenio = servDuenio.getDuenioById(idDuenio);
        
        if (duenio == null) {
            return ResponseEntity.notFound().build();
        }
        
        DuenioDetalleDTO duenioDetalleDTO = servDuenio.convertirADuenioDetalleDTO(duenio);
        
        return ResponseEntity.ok(duenioDetalleDTO);
    }
    
    @PostMapping ("/create")
    public ResponseEntity<String> createDuenio(@RequestBody DuenioCreateDTO dto) {
        
        servDuenio.createDuenio(dto);
        
        return ResponseEntity.status(HttpStatus.CREATED).body("Dueño creado correctamente");
    }
    
    @PutMapping ("/update")
    public ResponseEntity<String> updateDuenio(@RequestBody DuenioUpdateDTO dto) {
        
        servDuenio.updateDuenio(dto);
        
        return ResponseEntity.ok("Dueño actualizado correctamente");
    }
    
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteDuenioById(@PathVariable Long id) {
        
        Duenio duenio = servDuenio.getDuenioById(id);
        
        if (duenio != null) {
            servDuenio.deleteDuenioById(id);
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.noContent().build();
    }
}
