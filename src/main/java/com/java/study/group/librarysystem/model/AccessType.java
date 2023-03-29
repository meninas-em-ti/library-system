package com.java.study.group.librarysystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class AccessType {

    @Id
    private int accessId;
    private String role;

}
