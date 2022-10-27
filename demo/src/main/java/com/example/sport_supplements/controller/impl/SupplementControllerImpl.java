package com.example.sport_supplements.controller.impl;
import com.example.sport_supplements.controller.SupplementController;
import com.example.sport_supplements.model.Supplement;
import com.example.sport_supplements.service.SupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SupplementControllerImpl implements SupplementController {
    @Autowired
    private SupplementService supplementService;

    @Override
    public List<Supplement> findAll() {
        return supplementService.findAll();
    }

    @Override
    public Optional<Supplement> findById(Integer id) {
        return supplementService.findById(id);
    }

    @Override
    public int create(Supplement supplement) {
        return supplementService.create(supplement);
    }

    @Override
    public int update(Integer id, Supplement supplement) {
        return supplementService.update(id, supplement);
    }

    @Override
    public int delete(Integer id) {
        return supplementService.delete(id);
    }

    @Override
    public Optional<Supplement> findBySupplementName(String supplementName) {
        return supplementService.findBySupplementName(supplementName);
    }
}
