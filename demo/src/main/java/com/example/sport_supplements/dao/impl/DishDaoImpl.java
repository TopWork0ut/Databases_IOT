package com.example.sport_supplements.dao.impl;

import com.example.sport_supplements.dao.DishDao;
import com.example.sport_supplements.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DishDaoImpl implements DishDao {
    private static final String FIND_ALL = "SELECT * FROM dish";
    private static final String CREATE = "INSERT dish(name, components, calories, manufacturer, production_date, consumption_date) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE dish SET name=?, components=?, calories=?, manufacturer=?, production_date=?, consumption_date=? WHERE id=?";
    private static final String DELETE = "DELETE FROM dish WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM dish WHERE id=?";
    private static final String FIND_BY_DISH_NAME = "SELECT * FROM dish WHERE name=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Dish> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Dish.class));
    }

    @Override
    public Optional<Dish> findById(Integer id) {
        Optional<Dish> dish;
        try {
            dish = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Dish.class), id));
        } catch (EmptyResultDataAccessException e) {
            dish = Optional.empty();
        }
        return dish;
    }

    @Override
    public int create(Dish dish) {
        return jdbcTemplate.update(CREATE, dish.getName(), dish.getComponents(), dish.getCalories(),dish.getManufacturer(),dish.getProductionDate(),dish.getConsumptionDate());
    }

    @Override
    public int update(Integer id, Dish dish) {
        return jdbcTemplate.update(UPDATE, dish.getName(), dish.getComponents(), dish.getCalories(),dish.getManufacturer(),dish.getProductionDate(),dish.getConsumptionDate(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Dish> findByDishName(String dishName) {
        Optional<Dish> dish;
        try {
            dish = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_DISH_NAME,
                    BeanPropertyRowMapper.newInstance(Dish.class), dishName));
        } catch (EmptyResultDataAccessException e) {
            dish = Optional.empty();
        }
        return dish;
    }
}
