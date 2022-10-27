package com.example.sport_supplements.dao;

import com.example.sport_supplements.model.Supplement;
import java.util.Optional;

public interface SupplementDao extends GeneralDao<Supplement, Integer>{
    Optional<Supplement> findBySupplementName(String supplementName);

}
