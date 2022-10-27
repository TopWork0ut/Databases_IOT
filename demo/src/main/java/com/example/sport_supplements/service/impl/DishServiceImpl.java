package com.example.sport_supplements.service.impl;

import com.example.sport_supplements.dao.DishDao;
import com.example.sport_supplements.model.Dish;
import com.example.sport_supplements.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishDao dishDao;

    @Override
    public List<Dish> findAll() {
        return dishDao.findAll();
    }

    @Override
    public Optional<Dish> findById(Integer id) {
        return dishDao.findById(id);
    }

    @Override
    public int create(Dish dish) {
        return dishDao.create(dish);
    }

    @Override
    public int update(Integer id, Dish dish) {
        return dishDao.update(id, dish);
    }

    @Override
    public int delete(Integer id) {
        return dishDao.delete(id);
    }

    @Override
    public Optional<Dish> findByDishName(String dishName) {
        return dishDao.findByDishName(dishName);
    }
}