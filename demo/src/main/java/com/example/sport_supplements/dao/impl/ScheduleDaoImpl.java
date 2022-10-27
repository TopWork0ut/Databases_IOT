package com.example.sport_supplements.dao.impl;

import com.example.sport_supplements.dao.ScheduleDao;
import com.example.sport_supplements.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleDaoImpl implements ScheduleDao {
    private static final String FIND_ALL = "SELECT * FROM schedule";
    private static final String CREATE = "INSERT schedule(start_dieting,end_dieting,description) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE schedule SET start_dieting=?, end_dieting=?, description=? WHERE id=?";
    private static final String DELETE = "DELETE FROM schedule WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM schedule WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Schedule> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Schedule.class));
    }

    @Override
    public Optional<Schedule> findById(Integer id) {
        Optional<Schedule> schedule;
        try {
            schedule = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Schedule.class), id));
        } catch (EmptyResultDataAccessException e) {
            schedule = Optional.empty();
        }
        return schedule;
    }


    @Override
    public int create(Schedule schedule) {
        return jdbcTemplate.update(CREATE, schedule.getStartDieting(), schedule.getEndDieting(), schedule.getDescription());
    }

    @Override
    public int update(Integer id, Schedule schedule) {
        return jdbcTemplate.update(UPDATE, schedule.getStartDieting(), schedule.getEndDieting(), schedule.getDescription(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
