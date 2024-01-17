package com.empresa.dam.apiacuioximetro.repository;

import com.empresa.dam.apiacuioximetro.entity.Estanques;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class EstanquesRepositoryTest {
    @Autowired
    private EstanquesRepository estanquesRepository;


    void setUp() {
        estanquesRepository.save(Estanques.builder()
                .idEspecie(1)
                .idAcuicola(1)
                .tipoEstanque("Geomenbrana")
                .cantidadPeces(1000)
                .build()
        );

        estanquesRepository.save(Estanques.builder()
                .idEspecie(1)
                .idAcuicola(1)
                .tipoEstanque("Geomenbrana")
                .cantidadPeces(100)
                .build()
        );

        estanquesRepository.save(Estanques.builder()
                .idEspecie(1)
                .idAcuicola(1)
                .tipoEstanque("Geomenbrana")
                .cantidadPeces(1500)
                .build()
        );

        estanquesRepository.save(Estanques.builder()
                .idEspecie(1)
                .idAcuicola(1)
                .tipoEstanque("Geomenbrana")
                .cantidadPeces(1050)
                .build()
        );

        estanquesRepository.save(Estanques.builder()
                .idEspecie(1)
                .idAcuicola(1)
                .tipoEstanque("Geomenbrana")
                .cantidadPeces(1100)
                .build()
        );
    }

    @Test
    void EstanquesRepository_GetAllEstanquesByAcuicola_ReturnAllEstanques() {
        setUp();

        List<Estanques> getAllEstanques = estanquesRepository.findAllByIdAcuicola(1);
        System.out.println(getAllEstanques);

        Assertions.assertNotNull(getAllEstanques);
        Assertions.assertEquals(5, getAllEstanques.size());
    }

    @Test
    void EstanquesRepository_GetById_ReturnEstanqueById() {
        setUp();

        System.out.println(estanquesRepository.findAll());

        Estanques estanqueById = estanquesRepository.findById(6).get();
        System.out.println(estanqueById);

        Assertions.assertNotNull(estanqueById);
        Assertions.assertEquals(6, estanqueById.getId());
        Assertions.assertEquals(1, estanqueById.getIdEspecie());
        Assertions.assertEquals("Geomenbrana", estanqueById.getTipoEstanque());
        Assertions.assertEquals(1000, estanqueById.getCantidadPeces());
    }

    @Test
    void EstanquesRepository_UpdateEstanque_EstanqueUpdated() {
        setUp();

        Estanques estanque = Estanques.builder()
                .id(1)
                .idEspecie(2)
                .tipoEstanque("Fibra De Vidrio")
                .cantidadPeces(2000)
                .build();

        Estanques estanqueUpdate = estanquesRepository.save(estanque);

        Assertions.assertNotNull(estanqueUpdate);
        Assertions.assertEquals(estanque.getId(), estanqueUpdate.getId());
        Assertions.assertEquals(estanque.getIdEspecie(), estanqueUpdate.getIdEspecie());
        Assertions.assertEquals(estanque.getTipoEstanque(), estanqueUpdate.getTipoEstanque());
        Assertions.assertEquals(estanque.getCantidadPeces(), estanqueUpdate.getCantidadPeces());
    }
}