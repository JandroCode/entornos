package org.example.services;

import org.example.model.Examen;
import org.example.repositories.ExamenRepository;
import org.example.repositories.ExamenRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ExamenServiceImplTest {
    ExamenRepository repository;
    ExamenService service;



    @BeforeEach
    void setUp(){
        repository = Mockito.mock(ExamenRepository.class);
        service = new ExamenServiceImpl(repository);


    }

    @Test
    @DisplayName("Comprobando una lista de exámenes ...")
    void findExamenPorNombre() {
        //ExamenRepository repository = new ExamenRepositoryImpl();

        // Le indicamos a Mockito de que clase queremos hacer el "mock"
        /*
             ExamenRepository repository = Mockito.mock(ExamenRepository.class);
             ExamenService service = new ExamenServiceImpl(repository);
         */




        List<Examen> datos = Arrays.asList(new Examen(5L, "Matemáticas"),
                new Examen(6L, "Languaje"),
                new Examen(7L, "Historia"));

        Mockito.when(repository.findAll()).thenReturn(datos);


        Optional<Examen> examen = service.findExamenPorNombre("Matemáticas");


        Assertions.assertTrue(examen.isPresent());
        Assertions.assertEquals(5L, examen.get().getId());
        Assertions.assertEquals("Matemáticas", examen.get().getNombre());

    }


    @Test
    @DisplayName("Comprobando una lista vacía ...")
    void findExamenPorNombreListaVacia() {
        //ExamenRepository repository = new ExamenRepositoryImpl();

        // Le indicamos a Mockito de que clase queremos hacer el "mock"
        /*
              ExamenRepository repository = Mockito.mock(ExamenRepository.class);
              ExamenService service = new ExamenServiceImpl(repository);
         */




        List<Examen> datos = Collections.emptyList();

        Mockito.when(repository.findAll()).thenReturn(datos);


        Optional<Examen> examen = service.findExamenPorNombre("Matemáticas");


        Assertions.assertFalse(examen.isPresent());


    }
}