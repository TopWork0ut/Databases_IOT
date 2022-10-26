package com.example.sport_supplements.service.impl;

import com.example.sport_supplements.dao.SportsmanDao;
import com.example.sport_supplements.model.Sportsman;
import com.example.sport_supplements.service.SportsmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportsmanServiceImpl implements SportsmanService {
    @Autowired
    private SportsmanDao sportsmanDao;

    @Override
    public List<Sportsman> findAll() {
        return sportsmanDao.findAll();
    }

    @Override
    public Optional<Sportsman> findById(Integer id) {
        return sportsmanDao.findById(id);
    }

    @Override
    public int create(Sportsman sportsman) {
        return sportsmanDao.create(sportsman);
    }

    @Override
    public int update(Integer id, Sportsman sportsman) {
        return sportsmanDao.update(id, sportsman);
    }

    @Override
    public int delete(Integer id) {
        return sportsmanDao.delete(id);
    }

    @Override
    public Optional<Sportsman> findBySportsmanSurName(String sportsmanSurName) {
        return sportsmanDao.findBySportsmanSurName(sportsmanSurName);
    }
}
