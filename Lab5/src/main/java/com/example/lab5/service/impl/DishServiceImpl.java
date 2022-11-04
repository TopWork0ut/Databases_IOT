package com.example.lab5.service.impl;

import com.example.lab5.domain.Dish;
import com.example.lab5.domain.Schedule;
import com.example.lab5.exception.DishNotFoundException;
import com.example.lab5.exception.ScheduleNotFoundException;
import com.example.lab5.repository.DishRepository;
import com.example.lab5.repository.ScheduleRepository;
import com.example.lab5.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    DishRepository dishRepository;
    @Autowired
    ScheduleRepository scheduleRepository;

    public Dish findById(Integer id) {
        return dishRepository.findById(id)
                .orElseThrow(() -> new DishNotFoundException(id));
    }

    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    public List<Dish> findByName(String name) {
        return dishRepository.findByName(name);
    }

    public List<Dish> getDishesByScheduleId(Integer scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new ScheduleNotFoundException(scheduleId));
        return schedule.getDishes().stream().toList();
    }

    @Transactional
    public Dish create(Dish dish) {
        dishRepository.save(dish);
        return dish;
    }

    @Transactional
    public void update(Integer id, Dish dishParam) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new DishNotFoundException(id));
        //update
        dish.setName(dishParam.getName());
        dish.setComponents(dishParam.getComponents());
        dish.setCalories(dishParam.getCalories());
        dish.setManufacturer(dishParam.getManufacturer());
        dish.setProductionDate(dishParam.getProductionDate());
        dish.setConsumptionDate(dishParam.getConsumptionDate());
        dishRepository.save(dish);
    }

    @Transactional
    public void delete(Integer id) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new DishNotFoundException(id));
        dishRepository.delete(dish);
    }
}
