package com.example.sport_supplements.controller.impl;

import com.example.sport_supplements.controller.ScheduleSupplementController;
import com.example.sport_supplements.model.ScheduleSupplement;
import com.example.sport_supplements.service.ScheduleSupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleSupplementControllerImpl implements ScheduleSupplementController {
    @Autowired
    private ScheduleSupplementService scheduleSupplementService;

    @Override
    public List<ScheduleSupplement> findAll() {
        return scheduleSupplementService.findAll();
    }

    @Override
    public Optional<ScheduleSupplement> findById(Integer scheduleId, Integer supplementId) {
        return scheduleSupplementService.findById(scheduleId, supplementId);
    }

    @Override
    public int create(Integer scheduleId, Integer supplementId, ScheduleSupplement scheduleSupplement) {
        return scheduleSupplementService.create(scheduleId, supplementId, scheduleSupplement);
    }

    @Override
    public int update(Integer scheduleId, Integer supplementId,ScheduleSupplement scheduleSupplement) {
        return scheduleSupplementService.update(scheduleId, supplementId, scheduleSupplement);
    }

    @Override
    public int delete(Integer scheduleId, Integer supplementId) {
        return scheduleSupplementService.delete(scheduleId, supplementId);
    }

}
