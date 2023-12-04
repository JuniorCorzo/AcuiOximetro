package com.empresa.dam.apiacuioximetro.repository;

import com.empresa.dam.apiacuioximetro.entity.Estanques;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * EstanquesRepository es el repositorio encargado de gestionar las operaciones
 * CRUD de la entidad estanques
 */
@Repository
public interface EstanquesRepository extends ListCrudRepository<Estanques, Integer> {

}
