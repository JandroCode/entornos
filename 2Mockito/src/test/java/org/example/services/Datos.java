package org.example.services;

import org.example.model.Examen;

import java.util.Arrays;
import java.util.List;

public class Datos {


    public static final List<Examen> EXAMENES = Arrays.asList(new Examen(5L, "Matemáticas"),
            new Examen(6L, "Lenguaje"),
            new Examen(7L, "Historia"));

    public static final List<String> PREGUNTAS = Arrays.asList("aritméticas", "integrales" ,
            "derivadas", "trigonometría");

    public static final Examen EXAMEN = new Examen(8L, "Física");



}
