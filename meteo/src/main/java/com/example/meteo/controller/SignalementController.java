package com.example.meteo.controller;

import com.example.meteo.model.Signalement;
import com.example.meteo.service.SignalementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/signalements")
public class SignalementController {
    
    private final SignalementService service;

    public SignalementController(SignalementService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Signalement> ajouterSignalement(@RequestBody Signalement signalement) {
        Signalement savedSignalement = service.ajouterSignalement(signalement);
        return ResponseEntity.ok(savedSignalement);
    }

    @GetMapping
    public ResponseEntity<List<Signalement>> obtenirSignalements(
        @RequestParam double latitude,
        @RequestParam double longitude,
        @RequestParam double rayon
    ) {
        List<Signalement> signalements = service.obtenirSignalements(latitude, longitude, rayon);
        return ResponseEntity.ok(signalements);
    }
}
