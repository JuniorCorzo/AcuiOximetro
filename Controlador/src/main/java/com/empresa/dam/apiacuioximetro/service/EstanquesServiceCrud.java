package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.entity.Estanques;
import com.empresa.dam.apiacuioximetro.exceptions.DataNotFoundById;
import com.empresa.dam.apiacuioximetro.repository.EstanquesRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * EstanquesServiceCrud es el servicio encargado de gestionar las operaciones
 * CRUD
 * para la entidad 'estanques' en la base de datos AcuiOxímetro.
 */
@Service
@NoArgsConstructor
public class EstanquesServiceCrud {
    private EstanquesRepository repository;

    @Autowired
    public EstanquesServiceCrud(EstanquesRepository repository) {
        this.repository = repository;
    }

    /**
     * Devuelve una lista que contenga todos los datos almacenados en la base de
     * datos
     *
     * @return List<Estanques> - lista de objetos Estanques que contiene todos los
     * datos almacenados en la base de datos
     */
    public List<Estanques> getAll() {
        return this.repository.findAll();
    }

    /**
     * Realiza una consulta a la base de datos para recuperar todos los datos
     * de una fila específica utilizando su identificador único (ID).
     *
     * @param id - id de la fila que quieres devolver
     * @return devuelve un objecto de estanques con todos los datos de la fila
     * @throws RuntimeException - Si no exite el id
     */
    public Estanques getById(int id) throws DataNotFoundById {
        return this.repository.findById(id)
                .orElseThrow(() -> new DataNotFoundById("Estanques", id));
    }

    /**
     * Inserta un nuevo usuario a la base de datos en la entidad Estanques
     *
     * @param estanque - Objecto que almacena los datos necesarios de la entidad
     *                 estanques
     * @return
     */
    public Estanques create(Estanques estanque) {
        return this.repository.save(estanque);
    }

    /**
     * Actualiza la informacion de la entidad estanques
     *
     * @param estanque - Objecto que alamacena los datos necesarios de la entidad
     *                 estanques
     * @return
     * @throws RuntimeException - Si no exite el id
     */
    public Estanques update(Estanques estanque) throws DataNotFoundById {
        if (!this.repository.existsById(estanque.getId()))
            throw new DataNotFoundById("Estanques", estanque.getId());
        return this.repository.save(estanque);
    }

    /**
     * Elimina una fila de la base de datos utilizando su identificador único (ID).
     *
     * @param id - id de la fila que quieres eliminar
     * @return boolean - devuelve true si la fila fue eliminada exitosamente, de lo
     * contrario devuelve false
     */
    public boolean deleteById(int id) {
        this.repository.deleteById(id);
        return !this.repository.existsById(id);
    }
}
