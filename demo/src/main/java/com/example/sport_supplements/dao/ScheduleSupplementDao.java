package com.example.sport_supplements.dao;

import com.example.sport_supplements.model.ScheduleSupplement;
import java.util.List;
import java.util.Optional;

public interface ScheduleSupplementDao {
    List<ScheduleSupplement> findAll();

    Optional<ScheduleSupplement> findById(Integer scheduleId, Integer supplementId);

    int create(Integer scheduleId, Integer supplementId,ScheduleSupplement scheduleSupplement);

    int update(Integer scheduleId, Integer supplementId,ScheduleSupplement scheduleSupplement);

    int delete(Integer scheduleId, Integer supplementId);
}