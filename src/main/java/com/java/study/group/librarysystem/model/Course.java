package com.java.study.group.librarysystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.C;


import java.math.BigDecimal;
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
    @Column(name = "start_date_and_time")
    private LocalDateTime startDateAndTime;
    private String ageGroup;
    private BigDecimal priceOfClass;
    @Column(name = "instructor_name")
    private String instructorName;

}
