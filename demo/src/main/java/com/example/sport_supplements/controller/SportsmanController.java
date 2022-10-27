package com.example.sport_supplements.controller;

import com.example.sport_supplements.model.Sportsman;
import java.util.Optional;

public interface SportsmanController extends GeneralController<Sportsman, Integer> {
    Optional<Sportsman> findBySportsmanSurName(String sportsmanSurName);
}
