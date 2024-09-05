package com.java.study.group.librarysystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long courseID;
    private String name;
    @Column(name = "limit_of_customers")
    private int limitOfCustomers;
    @Column(name = "start_date_and_time")
    private LocalDateTime startDateAndTime;
    @Column(name = "age_group")
    private String ageGroup;
    @Column(name = "price_of_class")
    private BigDecimal priceOfClass;
    @Column(name = "instructor_name")
    private String instructorName;

}
