package com.empresa.dam.apiacuioximetro.repository;

import com.empresa.dam.apiacuioximetro.entity.HistoriaOxigeno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class HistoriaNivelRepositoryTest {

    @Autowired
    private HistoriaNivelRepository historiaRepository;

    @BeforeEach
    public void getHistoriaOxigeno() {
        List<HistoriaOxigeno> historiaNivelList;
        Instant now = Instant.now();
        historiaNivelList = new ArrayList<>();

        historiaNivelList.add(HistoriaOxigeno.builder()
                .idNivel(1)
                .idEstanque(1)
                .nivelOxigenacion(2.3)
                .fechaMedicion(Date.from(now.plus(30, ChronoUnit.MINUTES)))
                .build());

        historiaNivelList.add(HistoriaOxigeno.builder()
                .idNivel(2)
                .idEstanque(1)
                .nivelOxigenacion(2.1)
                .fechaMedicion(Date.from(now.plus(60, ChronoUnit.MINUTES)))
                .build());

        historiaNivelList.add(HistoriaOxigeno.builder()
                .idNivel(3)
                .idEstanque(1)
                .nivelOxigenacion(2.2)
                .fechaMedicion(Date.from(now.plus(90, ChronoUnit.MINUTES)))
                .build());

        historiaNivelList.add(HistoriaOxigeno.builder()
                .idNivel(4)
                .idEstanque(1)
                .nivelOxigenacion(2.4)
                .fechaMedicion(Date.from(now.plus(120, ChronoUnit.MINUTES)))
                .build());

        historiaNivelList.add(HistoriaOxigeno.builder()
                .idNivel(5)
                .idEstanque(1)
                .nivelOxigenacion(2.3)
                .fechaMedicion(Date.from(now.plus(160, ChronoUnit.MINUTES)))
                .build());

        historiaNivelList.add(HistoriaOxigeno.builder()
                .idNivel(6)
                .idEstanque(1)
                .nivelOxigenacion(2.4)
                .fechaMedicion(Date.from(now.plus(190, ChronoUnit.MINUTES)))
                .build());

        historiaNivelList.add(HistoriaOxigeno.builder()
                .idNivel(7)
                .idEstanque(1)
                .nivelOxigenacion(2.5)
                .fechaMedicion(Date.from(now.plus(220, ChronoUnit.MINUTES)))
                .build());

        historiaRepository.saveAll(historiaNivelList);
    }

    @Test
    void HistoriaNivelRepository_GetAllLevelOxygenById_ReturnAllLevelOxygenByIdEstanque() {
        List<HistoriaOxigeno> getOxygenLevel = historiaRepository.findAllByIdEstanque(1);

        Assertions.assertNotNull(getOxygenLevel);
        Assertions.assertEquals(7, getOxygenLevel.size());
    }

    @Test
    void HistoriaNivelRepository_GetFiveLastLevelOxygen_ReturnFiveLastLevelOxygen() {
        List<HistoriaOxigeno> getFiveLast = historiaRepository.findLastFive();
        System.out.println(getFiveLast);

        Assertions.assertNotNull(getFiveLast);
        Assertions.assertEquals(5, getFiveLast.size());
        Assertions.assertEquals(14, getFiveLast.get(0).getIdNivel());
        Assertions.assertEquals(13, getFiveLast.get(1).getIdNivel());
        Assertions.assertEquals(12, getFiveLast.get(2).getIdNivel());
        Assertions.assertEquals(11, getFiveLast.get(3).getIdNivel());
        Assertions.assertEquals(10, getFiveLast.get(4).getIdNivel());

        historiaRepository.deleteAll();
    }
}