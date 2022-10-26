package com.example.sport_supplements.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Supplement {
    private Integer id;
    private String name;
    private String components;
    private Integer calories;
    private String manufacturer;
    private LocalDate productionDate;
    private LocalDate consumptionDate;
}