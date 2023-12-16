package com.empresa.dam.apiacuioximetro.repository;

import com.empresa.dam.apiacuioximetro.entity.Acuicolas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcuicolaRepository extends JpaRepository<Acuicolas, Integer> {
}
