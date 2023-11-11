package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.entity.HistoriaOxigeno;
import com.empresa.dam.apiacuioximetro.exceptions.DataNotFoundById;
import com.empresa.dam.apiacuioximetro.repository.HistoriaNivelRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * HistoriaServiceCrud es el servicio encargado de gestionar las operaciones
 * CRUD de la entidad historia-oxigeno
 */

@Service
@Primary
@NoArgsConstructor
public class HistoriaServiceCrud {
    private HistoriaNivelRepository repository;

    // Inyecta el repositorio de historia-oxigeno
    @Autowired
    public HistoriaServiceCrud(HistoriaNivelRepository repository) {
        this.repository = repository;
    }

    /**
     * Devuelve todo el contenido de la tabla historia-oxigeno
     * 
     * @return List<HistoriaOxigeno> - Lista de objetos HistoriaOxigeno
     */
    public List<HistoriaOxigeno> findAll() {
        return this.repository.findAll();
    }

    /**
     * Devuelve el contenido de la tabla historia-oxigeno filtrado por id
     * 
     * @param id - id de la fila que quieres devolver
     * @return HistoriaOxigeno - Objeto HistoriaOxigeno correspondiente al id
     *         proporcionado
     * @throws RuntimeException - Si no existe el id
     */
    public HistoriaOxigeno findById(int id) throws DataNotFoundById {
        return this.repository.findById(id)
                .orElseThrow(() -> new DataNotFoundById("HistoriaOxigeno", id));
    }

    /**
     * Devuelve los ultimos 5 registros de la tabla historia-oxigeno
     * 
     * @return List<HistoriaOxigeno> - Lista de los últimos 5 objetos
     *         HistoriaOxigeno
     */
    public List<HistoriaOxigeno> findLasFive() {
        return this.repository.findLastFive();
    }
}
