package org.example.services;

import org.example.model.Examen;
import org.example.repositories.ExamenRepository;

import java.util.Optional;

public class ExamenServiceImpl implements ExamenService{

    private ExamenRepository examenRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }

    @Override
    public Optional<Examen> findExamenPorNombre(String nombre) {
         return examenRepository.findAll()
                 .stream()
                 .filter(e-> e.getNombre().contains(nombre))
                 .findFirst();

    }
}
