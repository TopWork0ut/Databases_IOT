package com.example.sport_supplements.controller.impl;

import com.example.sport_supplements.controller.ScheduleController;
import com.example.sport_supplements.model.Schedule;
import com.example.sport_supplements.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleControllerImpl implements ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @Override
    public List<Schedule> findAll() {
        return scheduleService.findAll();
    }

    @Override
    public Optional<Schedule> findById(Integer id) {
        return scheduleService.findById(id);
    }

    @Override
    public int create(Schedule schedule) {
        return scheduleService.create(schedule);
    }

    @Override
    public int update(Integer id, Schedule schedule) {
        return scheduleService.update(id, schedule);
    }

    @Override
    public int delete(Integer id) {
        return scheduleService.delete(id);
    }
}
