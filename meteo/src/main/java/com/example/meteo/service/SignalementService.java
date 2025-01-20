package com.example.meteo.service;

import com.example.meteo.model.Signalement;
import com.example.meteo.repository.SignalementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public class SignalementService {
    
    private final SignalementRepository repository;

    public SignalementService(SignalementRepository repository) {
        this.repository = repository;
    }

    public Signalement ajouterSignalement(Signalement signalement) {
        return repository.save(signalement);
    }

    public List<Signalement> obtenirSignalements(double latitude, double longitude, double rayon) {
        return repository.findSignalementsDansRayon(latitude, longitude, rayon);
    }
}
