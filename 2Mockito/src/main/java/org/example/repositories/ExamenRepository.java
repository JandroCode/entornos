package org.example.repositories;

import org.example.model.Examen;

import java.util.List;

public interface ExamenRepository {
    List<Examen> findAll();
}
