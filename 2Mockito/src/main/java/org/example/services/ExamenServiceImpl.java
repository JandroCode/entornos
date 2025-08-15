package org.example.services;

import org.example.model.Examen;
import org.example.repositories.ExamenRepository;
import org.example.repositories.PreguntaRepository;

import java.util.List;
import java.util.Optional;

public class ExamenServiceImpl implements ExamenService{

    private ExamenRepository examenRepository;
    private PreguntaRepository preguntaRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository,PreguntaRepository preguntaRepository) {
        this.examenRepository = examenRepository;
        this.preguntaRepository = preguntaRepository;
    }

    // Obtener el examen
    @Override
    public Optional<Examen> findExamenPorNombre(String nombre) {
         return examenRepository.findAll()
                 .stream()
                 .filter(e-> e.getNombre().contains(nombre))
                 .findFirst();

    }

    // Obtener el examen con sus preguntas
    @Override
    public Examen findExamenPorNombreConPreguntas(String nombre) {
        Optional<Examen> examenOptional = findExamenPorNombre(nombre);
        Examen examen = null;
        if(examenOptional.isPresent()){
            examen = examenOptional.get();
            List<String> preguntas = preguntaRepository.findPreguntasPorExamenId(examen.getId());
            examen.setPreguntas(preguntas);
        }

        return examen;
    }

    @Override
    public Examen guardarExamen(Examen examen) {

        if(!examen.getPreguntas().isEmpty()){
            preguntaRepository.guardarVarias(examen.getPreguntas());
        }

        return examenRepository.guardar(examen);
    }


}
