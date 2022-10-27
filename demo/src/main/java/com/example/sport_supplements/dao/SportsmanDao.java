package com.example.sport_supplements.dao;

import com.example.sport_supplements.model.Sportsman;
import java.util.Optional;

public interface SportsmanDao extends GeneralDao<Sportsman, Integer>{
    Optional<Sportsman> findBySportsmanSurName(String sportsmanSurName);
}
