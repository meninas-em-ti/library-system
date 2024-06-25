package com.java.study.group.librarysystem.repository;

import com.java.study.group.librarysystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findByName(String name);

    @Query(value = "select * from course where instructor_name=:instructorName  " +
            " and start_date_and_time > :startDate and start_date_and_time < :endDate", nativeQuery = true)
    List<Course> getListCourse(String instructorName, LocalDateTime startDate, LocalDateTime endDate);
}

