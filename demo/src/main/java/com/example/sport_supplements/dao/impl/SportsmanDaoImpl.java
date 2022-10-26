package com.example.sport_supplements.dao.impl;

import com.example.sport_supplements.dao.SportsmanDao;
import com.example.sport_supplements.model.Sportsman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportsmanDaoImpl implements SportsmanDao {
    private static final String FIND_ALL = "SELECT * FROM sportsman";
    private static final String CREATE = "INSERT sportsman(name, surname, kind_of_sport,height,weight,schedule_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE sportsman SET name=?, surname=?, kind_of_sport=?, height=?, weight=?, schedule_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM sportsman WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM sportsman WHERE id=?";
    private static final String FIND_BY_SPORTSMAN_SURNAME = "SELECT * FROM sportsman WHERE surname=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Sportsman> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Sportsman.class));
    }

    @Override
    public Optional<Sportsman> findById(Integer id) {
        Optional<Sportsman> sportsman;
        try {
            sportsman = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Sportsman.class), id));
        } catch (EmptyResultDataAccessException e) {
            sportsman = Optional.empty();
        }
        return sportsman;
    }

    @Override
    public int create(Sportsman sportsman) {
        return jdbcTemplate.update(CREATE, sportsman.getName(), sportsman.getSurname(), sportsman.getKindOfSport(), sportsman.getHeight(),sportsman.getWeight(),sportsman.getScheduleId());
    }

    @Override
    public int update(Integer id, Sportsman sportsman) {
        return jdbcTemplate.update(UPDATE, sportsman.getName(), sportsman.getSurname(), sportsman.getKindOfSport(), sportsman.getHeight(),sportsman.getWeight(),sportsman.getScheduleId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Sportsman> findBySportsmanSurName(String sportsmanSurName) {
        Optional<Sportsman> sportsman;
        try {
            sportsman = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_SPORTSMAN_SURNAME,
                    BeanPropertyRowMapper.newInstance(Sportsman.class), sportsmanSurName));
        } catch (EmptyResultDataAccessException e) {
            sportsman = Optional.empty();
        }
        return sportsman;
    }
}
