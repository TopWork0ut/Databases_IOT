package com.example.sport_supplements.dao.impl;

import com.example.sport_supplements.dao.ScheduleDishDao;
import com.example.sport_supplements.model.ScheduleDish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleDishDaoImpl implements ScheduleDishDao {
    private static final String FIND_ALL = "SELECT * FROM schedule_dish";
    private static final String CREATE = "INSERT schedule_dish(dish_id, schedule_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE schedule_dish SET dish_id=?, schedule_id=? WHERE dish_id=? and schedule_id=?";
    private static final String DELETE = "DELETE FROM schedule_dish WHERE dish_id=? and schedule_id=?";
    private static final String FIND_BY_ID = "SELECT * FROM schedule_dish WHERE dish_id=? and schedule_id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ScheduleDish> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(ScheduleDish.class));
    }

    @Override
    public Optional<ScheduleDish> findById(Integer scheduleId, Integer dishId) {
        Optional<ScheduleDish> scheduleDish;
        try {
            scheduleDish  = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(ScheduleDish.class), dishId, scheduleId));
        } catch (EmptyResultDataAccessException e) {
            scheduleDish = Optional.empty();
        }
        return scheduleDish;
    }

    @Override
    public int create(Integer scheduleId, Integer dishId,ScheduleDish scheduleDish) {
        return jdbcTemplate.update(CREATE, scheduleDish.getDishId(), scheduleDish.getScheduleId());
    }

    @Override
    public int update(Integer scheduleId, Integer dishId,ScheduleDish scheduleDish) {
        return jdbcTemplate.update(UPDATE, scheduleDish.getDishId(), scheduleDish.getScheduleId(), dishId, scheduleId);
    }

    @Override
    public int delete(Integer scheduleId, Integer dishId) {
        return jdbcTemplate.update(DELETE, dishId, scheduleId);
    }
}
