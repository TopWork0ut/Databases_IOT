package com.example.sport_supplements.service;

import com.example.sport_supplements.model.Supplement;
import java.util.Optional;

public interface SupplementService extends GeneralService<Supplement, Integer>{
    Optional<Supplement> findBySupplementName(String supplementName);
}
