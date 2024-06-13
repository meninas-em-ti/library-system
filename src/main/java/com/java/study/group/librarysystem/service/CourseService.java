package com.java.study.group.librarysystem.service;

import com.java.study.group.librarysystem.dto.CourseRegisterDto;
import com.java.study.group.librarysystem.model.Course;
import com.java.study.group.librarysystem.repository.CourseRepository;
import com.java.study.group.librarysystem.service.exceptions.CourseAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;

    public Boolean register(final CourseRegisterDto courseDto) {

        if (courseDto == null) {
            throw new NullPointerException("Course details is null.");
        }

        try {
            verifyCourseRegister(courseDto.getName());
            repository.save(courseDto.toCourse());
            return true;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error while trying to save the course in the database", e);
        }

    }


        public Boolean verifyCourseRegister (String name){
            List<Course> courseRegistered = this.repository.findByName(name);
            boolean isCourseRegistered = false;
            if (courseRegistered.size() > 0) {
                isCourseRegistered = true;
                System.out.println("checking if course already exist");
                throw new CourseAlreadyExistException("Course is already registered");

            }

            return isCourseRegistered;
        }
    }

