package com.java.study.group.librarysystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Login {
    @Id
    private Long id;
    private String username;
    private String password;

}
