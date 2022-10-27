package com.example.sport_supplements.service.impl;

import com.example.sport_supplements.dao.ScheduleDishDao;
import com.example.sport_supplements.model.ScheduleDish;
import com.example.sport_supplements.service.ScheduleDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleDishServiceImpl implements ScheduleDishService {
    @Autowired
    private ScheduleDishDao scheduleDishDao;

    @Override
    public int create(Integer scheduleId, Integer dishId,ScheduleDish scheduleDish) {
        return scheduleDishDao.create(scheduleId, dishId,scheduleDish);
    }

    @Override
    public int update(Integer scheduleId, Integer dishId,ScheduleDish scheduleDish) {
        return scheduleDishDao.update(scheduleId, dishId,scheduleDish);
    }

    @Override
    public int delete(Integer scheduleId, Integer dishId) {
        return scheduleDishDao.delete(scheduleId, dishId);
    }

    @Override
    public List<ScheduleDish> findAll() {
        return scheduleDishDao.findAll();
    }

    @Override
    public Optional<ScheduleDish> findById(Integer scheduleId, Integer dishId) {
        return scheduleDishDao.findById(scheduleId, dishId);
    }
}
