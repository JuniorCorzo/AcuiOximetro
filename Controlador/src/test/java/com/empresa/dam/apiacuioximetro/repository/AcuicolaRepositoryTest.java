package com.empresa.dam.apiacuioximetro.repository;

import com.empresa.dam.apiacuioximetro.entity.Acuicolas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class AcuicolaRepositoryTest {
    @Autowired
    private AcuicolaRepository acuicolaRepository;

    @BeforeEach
    void setUp() {
        acuicolaRepository.save(Acuicolas.builder()
                .idAcuicola(1)
                .nombre("Pisicola")
                .direccion("la ye")
                .idEstanque(1)
                .idUsuario(1234567890)
                .build());

        acuicolaRepository.save(Acuicolas.builder()
                .idAcuicola(2)
                .nombre("Pisicola Pedregales")
                .direccion("pedregales")
                .idEstanque(1)
                .idUsuario(1234567891)
                .build());
    }

    @Test
    void AcuicolaRepository_FindByIdAcuicola_ReturnAcuicolaById(){
        Acuicolas acuicolaById = acuicolaRepository.findById(1).get();

        Assertions.assertNotNull(acuicolaById);
        Assertions.assertEquals(1, acuicolaById.getIdAcuicola());
        Assertions.assertEquals("Pisicola", acuicolaById.getNombre());
        Assertions.assertEquals("la ye", acuicolaById.getDireccion());
        Assertions.assertEquals(1, acuicolaById.getIdEstanque());
        Assertions.assertEquals(1234567890, acuicolaById.getIdUsuario());
    }

}