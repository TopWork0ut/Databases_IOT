package com.example.sport_supplements.dao.impl;

import com.example.sport_supplements.dao.ScheduleSupplementDao;
import com.example.sport_supplements.model.ScheduleSupplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleSupplementDaoImpl implements ScheduleSupplementDao {
    private static final String FIND_ALL = "SELECT * FROM schedule_supplement";
    private static final String CREATE = "INSERT schedule_supplement(schedule_id, supplement_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE schedule_supplement SET schedule_id=?, supplement_id=? WHERE schedule_id=? and supplement_id=?";
    private static final String DELETE = "DELETE FROM schedule_supplement WHERE schedule_id=? and supplement_id=?";
    private static final String FIND_BY_ID = "SELECT * FROM schedule_supplement WHERE schedule_id=? and supplement_id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ScheduleSupplement> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(ScheduleSupplement.class));
    }

    @Override
    public Optional<ScheduleSupplement> findById(Integer scheduleId, Integer supplementId) {
        Optional<ScheduleSupplement> scheduleSupplement;
        try {
            scheduleSupplement  = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(ScheduleSupplement.class), scheduleId, supplementId));
        } catch (EmptyResultDataAccessException e) {
            scheduleSupplement = Optional.empty();
        }
        return scheduleSupplement;
    }

    @Override
    public int create(Integer scheduleId, Integer supplementId,ScheduleSupplement scheduleSupplement) {
        return jdbcTemplate.update(CREATE, scheduleSupplement.getScheduleId(), scheduleSupplement.getSupplementId());
    }

    @Override
    public int update(Integer scheduleId, Integer supplementId,ScheduleSupplement scheduleSupplement) {
        return jdbcTemplate.update(UPDATE, scheduleSupplement.getScheduleId(), scheduleSupplement.getSupplementId(), scheduleId, supplementId);
    }

    @Override
    public int delete(Integer scheduleId, Integer supplementId) {
        return jdbcTemplate.update(DELETE, scheduleId, supplementId);
    }
}
