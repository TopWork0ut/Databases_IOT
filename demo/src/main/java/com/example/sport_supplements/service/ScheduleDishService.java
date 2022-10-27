package com.example.sport_supplements.service;

import com.example.sport_supplements.model.ScheduleDish;

import java.util.List;
import java.util.Optional;

public interface ScheduleDishService{
    List<ScheduleDish> findAll();

    Optional<ScheduleDish> findById(Integer scheduleId, Integer dishId);

    int create(Integer scheduleId, Integer dishId,ScheduleDish scheduleDish);

    int update(Integer scheduleId, Integer dishId,ScheduleDish scheduleDish);

    int delete(Integer scheduleId, Integer dishId);
}
