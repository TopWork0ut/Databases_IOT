package com.example.sport_supplements.service.impl;

import com.example.sport_supplements.dao.ScheduleDao;
import com.example.sport_supplements.model.Schedule;
import com.example.sport_supplements.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleDao scheduleDao;

    @Override
    public List<Schedule> findAll() {
        return scheduleDao.findAll();
    }

    @Override
    public Optional<Schedule> findById(Integer id) {
        return scheduleDao.findById(id);
    }

    @Override
    public int create(Schedule schedule) {
        return scheduleDao.create(schedule);
    }

    @Override
    public int update(Integer id, Schedule schedule) {
        return scheduleDao.update(id, schedule);
    }

    @Override
    public int delete(Integer id) {
        return scheduleDao.delete(id);
    }
}
