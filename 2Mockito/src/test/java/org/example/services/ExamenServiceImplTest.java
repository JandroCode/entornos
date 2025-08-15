package org.example.services;

import org.example.model.Examen;
import org.example.repositories.ExamenRepository;
import org.example.repositories.PreguntaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.*;


class ExamenServiceImplTest {
    PreguntaRepository preguntaRepository;
    ExamenRepository repository;
    ExamenService service;


    @BeforeEach
    void setUp(){
        repository = Mockito.mock(ExamenRepository.class);
        preguntaRepository = Mockito.mock(PreguntaRepository.class);
        service = new ExamenServiceImpl(repository, preguntaRepository);
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

        /*
                List<Examen> datos = Arrays.asList(new Examen(5L, "Matemáticas"),
                new Examen(6L, "Lenguaje"),
                new Examen(7L, "Historia"));

         */



        Mockito.when(repository.findAll()).thenReturn(Datos.EXAMENES);

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

    @Test
    void testPreguntasExamen(){
        Mockito.when(repository.findAll()).thenReturn(Datos.EXAMENES);
        Mockito.when(preguntaRepository.findPreguntasPorExamenId(Mockito.anyLong())).thenReturn(Datos.PREGUNTAS);

        Examen examen = service.findExamenPorNombreConPreguntas("Matemáticas");
        Assertions.assertEquals(4, examen.getPreguntas().size());
        Assertions.assertTrue(examen.getPreguntas().contains("derivadas"));
    }

    @Test
    void testPreguntasExamenVerify(){
        Mockito.when(repository.findAll()).thenReturn(Datos.EXAMENES);
        Mockito.when(preguntaRepository.findPreguntasPorExamenId(Mockito.anyLong())).thenReturn(Datos.PREGUNTAS);

        Examen examen = service.findExamenPorNombreConPreguntas("Matemáticas");
        Assertions.assertEquals(4, examen.getPreguntas().size());
        Assertions.assertTrue(examen.getPreguntas().contains("derivadas"));

        Mockito.verify(repository).findAll();
        Mockito.verify(preguntaRepository).findPreguntasPorExamenId(5L);

    }

    @Test
    void testGuardarExamen(){

        Examen newExamen = Datos.EXAMEN;
        newExamen.setPreguntas(Datos.PREGUNTAS);

        // Cuando pasemos cualquier tipo de examen que devuelve el EXAMEN de Datos
        Mockito.when(repository.guardar(Mockito.any(Examen.class))).thenReturn(Datos.EXAMEN);
        Examen examen = service.guardarExamen(Datos.EXAMEN);
        Assertions.assertNotNull(examen.getId());
        Assertions.assertEquals(8L, examen.getId());
        Assertions.assertEquals("Física" , examen.getNombre());

        Mockito.verify(repository).guardar(Mockito.any(Examen.class));
        Mockito.verify(preguntaRepository).guardarVarias(Mockito.anyList());


    }
}