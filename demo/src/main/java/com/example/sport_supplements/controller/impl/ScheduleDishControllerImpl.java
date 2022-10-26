package com.example.sport_supplements.controller.impl;
import com.example.sport_supplements.controller.ScheduleDishController;
import com.example.sport_supplements.model.ScheduleDish;
import com.example.sport_supplements.service.ScheduleDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleDishControllerImpl implements ScheduleDishController {
    @Autowired
    private ScheduleDishService scheduleDishService;

    @Override
    public List<ScheduleDish> findAll() {
        return scheduleDishService.findAll();
    }

    @Override
    public Optional<ScheduleDish> findById(Integer scheduleId, Integer dishId) {
        return scheduleDishService.findById(scheduleId, dishId);
    }

    @Override
    public int create(Integer scheduleId, Integer dishId,ScheduleDish scheduleDish) {
        return scheduleDishService.create(scheduleId, dishId, scheduleDish);
    }

    @Override
    public int update(Integer scheduleId, Integer dishId,ScheduleDish scheduleDish) {
        return scheduleDishService.update(scheduleId, dishId, scheduleDish);
    }

    @Override
    public int delete(Integer scheduleId, Integer dishId) {
        return scheduleDishService.delete(scheduleId, dishId);
    }

}
