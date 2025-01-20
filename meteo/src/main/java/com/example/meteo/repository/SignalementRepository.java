package com.example.meteo.repository;


import com.example.meteo.model.Signalement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;



public interface SignalementRepository extends JpaRepository<Signalement, Long> {

    @Query("SELECT s FROM Signalement s WHERE " +
           "SQRT(POWER(s.latitude - :latitude, 2) + POWER(s.longitude - :longitude, 2)) <= :rayon " +
           "AND DATE(s.horodatage) = CURRENT_DATE")
    List<Signalement> findSignalementsDansRayon(
        @Param("latitude") double latitude,
        @Param("longitude") double longitude,
        @Param("rayon") double rayon
    );
}
