package com.java.study.group.librarysystem.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCourseDto implements Serializable {

    private String username;
    private String password;
}
