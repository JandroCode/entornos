package org.example.repositories;

import org.example.model.Examen;

import java.util.Arrays;
import java.util.List;

public class ExamenRepositoryImpl implements  ExamenRepository{

    @Override
    public List<Examen> findAll() {
        return Arrays.asList(new Examen(5L, "Matemáticas"),
                new Examen(6L, "Languaje"),
                new Examen(7L, "Historia"));
    }

    @Override
    public Examen guardar(Examen examen) {
        return null;
    }
}
