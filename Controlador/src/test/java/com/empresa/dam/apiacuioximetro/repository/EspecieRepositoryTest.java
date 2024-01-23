package com.empresa.dam.apiacuioximetro.repository;

import com.empresa.dam.apiacuioximetro.dto.EspecieDTO;
import com.empresa.dam.apiacuioximetro.entity.Especies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
class EspecieRepositoryTest {
    @Autowired
    private EspecieRepository especieRepository;

    @BeforeEach
    public void setUp() {
        especieRepository.save(Especies.builder()
                .nombre("Cachama")
                .build());

        especieRepository.save(Especies.builder()
                .nombre("Trucha")
                .build());
    }

    @Test
    void EspecieRepository_FindById_ReturnEspecieById(){
        Especies especieById = especieRepository.findById(1).get();

        Assertions.assertNotNull(especieById);
        Assertions.assertEquals(1, especieById.getId());
        Assertions.assertEquals("Cachama", especieById.getNombre());
    }

    @Test
    void EspecieRepository_FindAllNombres_ReturnAllNombresEspecies(){
        List<EspecieDTO> getAllNombresEspecies = this.especieRepository.findAllNombre();

        Assertions.assertNotNull(getAllNombresEspecies);
        Assertions.assertEquals(2, getAllNombresEspecies.size());
        Assertions.assertEquals("Trucha", getAllNombresEspecies.get(1).getNombre());
    }
}