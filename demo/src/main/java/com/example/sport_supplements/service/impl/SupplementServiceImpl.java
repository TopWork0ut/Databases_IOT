package com.example.sport_supplements.service.impl;

import com.example.sport_supplements.dao.SupplementDao;
import com.example.sport_supplements.model.Supplement;
import com.example.sport_supplements.service.SupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplementServiceImpl implements SupplementService {
    @Autowired
    private SupplementDao supplementDao;

    @Override
    public List<Supplement> findAll() {
        return supplementDao.findAll();
    }

    @Override
    public Optional<Supplement> findById(Integer id) {
        return supplementDao.findById(id);
    }

    @Override
    public int create(Supplement supplement) {
        return supplementDao.create(supplement);
    }

    @Override
    public int update(Integer id, Supplement supplement) {
        return supplementDao.update(id, supplement);
    }

    @Override
    public int delete(Integer id) {
        return supplementDao.delete(id);
    }

    @Override
    public Optional<Supplement> findBySupplementName(String supplementName) {
        return supplementDao.findBySupplementName(supplementName);
    }
}
