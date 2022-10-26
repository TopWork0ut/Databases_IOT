package com.example.sport_supplements.dao;

import com.example.sport_supplements.model.Dish;

import java.util.Optional;

public interface DishDao extends GeneralDao<Dish, Integer>{
    Optional<Dish> findByDishName(String dishName);
}
