package com.example.sport_supplements.service;

import com.example.sport_supplements.model.Dish;

import java.util.Optional;

public interface DishService extends GeneralService<Dish, Integer> {
    Optional<Dish> findByDishName(String dishName);
}
