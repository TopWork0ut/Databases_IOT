package com.example.lab5.service;

import com.example.lab5.domain.Dish;

import java.util.List;

public interface DishService extends GeneralService<Dish, Integer>{
    List<Dish> findByName(String name);

    List<Dish> getDishesByScheduleId(Integer scheduleId);
}
