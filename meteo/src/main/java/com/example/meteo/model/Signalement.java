package com.example.meteo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

public class Signalement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;
    private double longitude;

    @Enumerated(EnumType.STRING)
    private TempsSignificatif temps;

    private double temperature;

    private LocalDateTime horodatage;

    @PrePersist
    public void prePersist() {
        this.horodatage = LocalDateTime.now();
    }

    // Getters et setters
}
