package com.example.sport_supplements.controller.impl;
import com.example.sport_supplements.controller.SportsmanController;
import com.example.sport_supplements.model.Sportsman;
import com.example.sport_supplements.service.SportsmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SportsmanControllerImpl implements SportsmanController {
    @Autowired
    private SportsmanService sportsmanService;

    @Override
    public List<Sportsman> findAll() {
        return sportsmanService.findAll();
    }

    @Override
    public Optional<Sportsman> findById(Integer id) {
        return sportsmanService.findById(id);
    }

    @Override
    public int create(Sportsman sportsman) {
        return sportsmanService.create(sportsman);
    }

    @Override
    public int update(Integer id, Sportsman sportsman) {
        return sportsmanService.update(id, sportsman);
    }

    @Override
    public int delete(Integer id) {
        return sportsmanService.delete(id);
    }

    @Override
    public Optional<Sportsman> findBySportsmanSurName(String sportsmanSurName) {
        return sportsmanService.findBySportsmanSurName(sportsmanSurName);
    }
}
