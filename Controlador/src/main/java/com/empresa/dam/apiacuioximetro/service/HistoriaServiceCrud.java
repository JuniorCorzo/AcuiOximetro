package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.entity.HistoriaOxigeno;
import com.empresa.dam.apiacuioximetro.exceptions.DataNotFound;
import com.empresa.dam.apiacuioximetro.exceptions.DataNotFoundById;
import com.empresa.dam.apiacuioximetro.repository.HistoriaNivelRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
    @Deprecated
    public List<HistoriaOxigeno> getAll() {
        return this.repository.findAll();
    }

    /**
     * Devuelve el contenido de la tabla historia-oxigeno filtrado por id
     *
     * @param id - id de la fila que quieres devolver
     * @return HistoriaOxigeno - Objeto HistoriaOxigeno correspondiente al id
     * proporcionado
     * @throws RuntimeException - Si no existe el id
     */
    public List<HistoriaOxigeno> getByIdEstanques(int id) throws DataNotFoundById {
        List<HistoriaOxigeno> historiaOxigenoList = this.repository.findAllByIdEstanque(id);
        if (historiaOxigenoList.isEmpty()) {
            throw new DataNotFoundById("HistoriaOxigeno", id);
        }
        return historiaOxigenoList;
    }

    /**
     * Devuelve los ultimos 5 registros de la tabla historia-oxigeno
     * 
     * @return List<HistoriaOxigeno> - Lista de los últimos 5 objetos
     *         HistoriaOxigeno
     */
    public List<HistoriaOxigeno> findLasFive() throws DataNotFound {
        List<HistoriaOxigeno> historiaOxigenoList = this.repository.findLastFive();
        if (historiaOxigenoList.isEmpty()) throw new DataNotFound("HistoriaOxigeno");
        return historiaOxigenoList;
    }
}
