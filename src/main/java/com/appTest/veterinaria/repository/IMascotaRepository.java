package com.appTest.veterinaria.repository;

import com.appTest.veterinaria.model.Mascota;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMascotaRepository extends JpaRepository <Mascota, Long>{
    List<Mascota> findByEspecieAndRaza(String especie, String raza);
}
