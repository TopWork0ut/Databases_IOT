package com.example.sport_supplements.controller;

import com.example.sport_supplements.model.Supplement;
import java.util.Optional;

public interface SupplementController extends GeneralController<Supplement, Integer>{
    Optional<Supplement> findBySupplementName(String supplementName);
}
