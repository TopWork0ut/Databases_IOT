package com.example.sport_supplements.controller;

import com.example.sport_supplements.model.Dish;

import java.util.Optional;

public interface DishController extends GeneralController<Dish, Integer>{
    Optional<Dish> findByDishName(String dishName);
}
