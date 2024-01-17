package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.entity.Estanques;
import com.empresa.dam.apiacuioximetro.exceptions.DataNotFoundById;
import com.empresa.dam.apiacuioximetro.repository.EstanquesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EstanquesServiceCrudTest {
    @Mock
    private EstanquesRepository estanquesRepository;
    @InjectMocks
    private EstanquesServiceCrud estanquesService;

    @Test
    void EstanqueService_getAllEstanques_ReturnAllEstanques(){
        List<Estanques> estanques = Collections.emptyList();

        when(this.estanquesRepository.findAllByIdAcuicola(Mockito.anyInt())).thenReturn(estanques);
        List<Estanques> getEstanques = this.estanquesService.getAllByAcuicola(1);

        Assertions.assertNotNull(getEstanques);
    }

    @Test
    void EstanquesService_GetEstanqueById_ReturnEstanqueById() throws DataNotFoundById {
        Estanques estanque = Estanques.builder()
                .id(1)
                .idEspecie(1)
                .tipoEstanque("Geomenbrana")
                .cantidadPeces(1000)
                .build();

        when(estanquesRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(estanque));
        Estanques estanqueById = estanquesService.getById(1);

        Assertions.assertNotNull(estanqueById);
    }

    @Test
    void EstanqueService_GetEstanqueById_ThrowsDataNotFoundId(){
        Assertions.assertThrows(DataNotFoundById.class, () -> estanquesService.getById(1));
    }

    @Test
    void EstanquesService_CreateEstanque_ReturnEstanqueCreated(){
        Estanques estanque = Estanques.builder()
                .id(1)
                .idEspecie(1)
                .tipoEstanque("Geomenbrana")
                .cantidadPeces(1000)
                .build();

        when(estanquesRepository.save(Mockito.any(Estanques.class))).thenReturn(estanque);
        Estanques saveEstanque = estanquesService.create(estanque);

        Assertions.assertNotNull(saveEstanque);
    }

    @Test
    void EstanquesService_UpdateEstanque_ReturnEstanqueUpdated() throws DataNotFoundById {
        Estanques estanque = Estanques.builder()
                .id(1)
                .idEspecie(1)
                .tipoEstanque("Geomenbrana")
                .cantidadPeces(1000)
                .build();

        when(estanquesRepository.existsById(Mockito.anyInt())).thenReturn(true);
        when(estanquesRepository.save(Mockito.any(Estanques.class))).thenReturn(estanque);
        Estanques updateEstanque = estanquesService.update(estanque);

        Assertions.assertNotNull(estanque);
    }

    @Test
    void EstanqueService_UpdateEstanque_ThrowDataNotFoundById(){
        Estanques estanque = Estanques.builder()
                .id(1)
                .idEspecie(1)
                .tipoEstanque("Geomenbrana")
                .cantidadPeces(1000)
                .build();

        Assertions.assertThrows(DataNotFoundById.class, () -> estanquesService.update(estanque));
    }
}