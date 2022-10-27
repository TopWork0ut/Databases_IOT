package com.example.sport_supplements.service;

import com.example.sport_supplements.model.Sportsman;
import java.util.Optional;

public interface SportsmanService extends GeneralService<Sportsman, Integer> {
    Optional<Sportsman> findBySportsmanSurName(String sportsmanSurName);
}
