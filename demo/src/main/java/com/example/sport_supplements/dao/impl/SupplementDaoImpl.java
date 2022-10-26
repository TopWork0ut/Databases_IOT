package com.example.sport_supplements.dao.impl;

import com.example.sport_supplements.dao.SupplementDao;
import com.example.sport_supplements.model.Supplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplementDaoImpl implements SupplementDao {
    private static final String FIND_ALL = "SELECT * FROM supplement";
    private static final String CREATE = "INSERT supplement(name, components, calories, manufacturer, production_date, consumption_date) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE supplement SET name=?, components=?, calories=?, manufacturer=?, production_date=?, consumption_date=? WHERE id=?";
    private static final String DELETE = "DELETE FROM supplement WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM supplement WHERE id=?";
    private static final String FIND_BY_SUPPLEMENT_NAME = "SELECT * FROM supplement WHERE name=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Supplement> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Supplement.class));
    }

    @Override
    public Optional<Supplement> findById(Integer id) {
        Optional<Supplement> supplement;
        try {
            supplement = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Supplement.class), id));
        } catch (EmptyResultDataAccessException e) {
            supplement = Optional.empty();
        }
        return supplement;
    }

    @Override
    public int create(Supplement supplement) {
        return jdbcTemplate.update(CREATE, supplement.getName(), supplement.getComponents(), supplement.getCalories(),supplement.getManufacturer(),supplement.getProductionDate(),supplement.getConsumptionDate());
    }

    @Override
    public int update(Integer id, Supplement supplement) {
        return jdbcTemplate.update(UPDATE, supplement.getName(), supplement.getComponents(), supplement.getCalories(),supplement.getManufacturer(),supplement.getProductionDate(),supplement.getConsumptionDate(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Supplement> findBySupplementName(String supplementName) {
        Optional<Supplement> supplement;
        try {
            supplement = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_SUPPLEMENT_NAME,
                    BeanPropertyRowMapper.newInstance(Supplement.class), supplementName));
        } catch (EmptyResultDataAccessException e) {
            supplement = Optional.empty();
        }
        return supplement;
    }
}
