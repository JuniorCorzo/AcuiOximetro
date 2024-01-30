package com.empresa.dam.apiacuioximetro.repository;

import com.empresa.dam.apiacuioximetro.dto.EstanqueDTO;
import com.empresa.dam.apiacuioximetro.entity.Estanques;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * EstanquesRepository es el repositorio encargado de gestionar las operaciones
 * CRUD de la entidad estanques
 */
@Repository
public interface EstanquesRepository extends JpaRepository<Estanques, Integer> {
    @Modifying
    @Query("""
            SELECT DISTINCT new com.empresa.dam.apiacuioximetro.dto.EstanqueDTO (estanque.id, especies.nombre, estanque.tipoEstanque, estanque.cantidadPeces) 
            FROM Estanques estanque JOIN Especies especies ON estanque.idEspecie = especies.id 
            WHERE estanque.idAcuicola = :idAcuicola
            """)
    @Transactional
    Set<EstanqueDTO> findAllByIdAcuicola(@Param("idAcuicola") int idAcuicola);
}
