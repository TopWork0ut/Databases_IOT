package com.example.lab5.repository;

import com.example.lab5.domain.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {
    List<Dish> findByName(String surname);

    @Modifying()
    @Query("DELETE FROM Dish dish WHERE dish.id=?1")
    void deleteById(Integer id);
}
