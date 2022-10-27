package com.example.sport_supplements.controller.impl;

import com.example.sport_supplements.controller.DishController;
import com.example.sport_supplements.model.Dish;
import com.example.sport_supplements.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishControllerImpl implements DishController {
    @Autowired
    private DishService dishService;

    @Override
    public List<Dish> findAll() {
        return dishService.findAll();
    }

    @Override
    public Optional<Dish> findById(Integer id) {
        return dishService.findById(id);
    }

    @Override
    public int create(Dish dish) {
        return dishService.create(dish);
    }

    @Override
    public int update(Integer id, Dish dish) {
        return dishService.update(id, dish);
    }

    @Override
    public int delete(Integer id) {
        return dishService.delete(id);
    }

    @Override
    public Optional<Dish> findByDishName(String dishName) {
        return dishService.findByDishName(dishName);
    }
}
