package com.java.study.group.librarysystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
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
