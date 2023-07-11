package com.java.study.group.librarysystem.service;

import com.java.study.group.librarysystem.dto.CourseDto;
import com.java.study.group.librarysystem.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

  private final CourseRepository repository;

  public Boolean register(final CourseDto courseDto) throws Exception {

    Boolean isCourseRegistered = false;

    if(courseDto == null){
      throw new Exception("Course details is null.");
    }

    try {
      repository.save(courseDto.toCourse());
      isCourseRegistered = true;
    } catch (Exception e) {
      throw new Exception("Error while trying to save the course in the database", e);
    }

    return isCourseRegistered;
  }
}
