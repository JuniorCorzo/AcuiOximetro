package com.empresa.dam.apiacuioximetro.repository;

import com.empresa.dam.apiacuioximetro.dto.EspecieDTO;
import com.empresa.dam.apiacuioximetro.entity.Especies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspecieRepository extends JpaRepository<Especies, Integer> {
    @Query("""
            SELECT new com.empresa.dam.apiacuioximetro.dto.EspecieDTO(e.nombre)
            FROM Especies e
            """)
    List<EspecieDTO> findAllNombre();
}
