package com.example.sport_supplements.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sportsman {
    private Integer id;
    private String name;
    private String surname;
    private String kindOfSport;
    private Integer height;
    private Integer weight;
    private Integer scheduleId;
}
