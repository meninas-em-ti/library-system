package com.java.study.group.librarysystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseID;
    private String name;
    private int limitOfCostumers;
    private LocalDateTime startDateAndTime;
    private String ageGroup;
    private Long priceOfClass;
    private String instructorName;

}
