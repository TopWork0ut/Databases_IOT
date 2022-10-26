package com.example.sport_supplements.service.impl;

import com.example.sport_supplements.dao.ScheduleSupplementDao;
import com.example.sport_supplements.model.ScheduleSupplement;
import com.example.sport_supplements.service.ScheduleSupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleSupplementServiceImpl implements ScheduleSupplementService {
    @Autowired
    private ScheduleSupplementDao scheduleSupplementDao;

    @Override
    public int create(Integer scheduleId, Integer supplementId, ScheduleSupplement scheduleSupplement) {
        return scheduleSupplementDao.create(scheduleId, supplementId,scheduleSupplement);
    }

    @Override
    public int update(Integer scheduleId, Integer supplementId,ScheduleSupplement scheduleSupplement) {
        return scheduleSupplementDao.update(scheduleId, supplementId,scheduleSupplement);
    }

    @Override
    public int delete(Integer scheduleId, Integer supplementId) {
        return scheduleSupplementDao.delete(scheduleId, supplementId);
    }

    @Override
    public List<ScheduleSupplement> findAll() {
        return scheduleSupplementDao.findAll();
    }

    @Override
    public Optional<ScheduleSupplement> findById(Integer scheduleId, Integer supplementId) {
        return scheduleSupplementDao.findById(scheduleId, supplementId);
    }
}
