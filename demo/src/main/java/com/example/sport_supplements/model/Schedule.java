package com.example.sport_supplements.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Schedule {
    private Integer id;
    private LocalDate startDieting;
    private LocalDate endDieting;
    private String description;
}
