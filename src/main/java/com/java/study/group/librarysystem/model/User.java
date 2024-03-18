package com.java.study.group.librarysystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    private Long id;
    private String fullName;
    private String address;
    private String email;
    private String phone;
    private Date dateOfBirth;

}
