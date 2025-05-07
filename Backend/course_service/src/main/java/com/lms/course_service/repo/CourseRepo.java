package com.lms.course_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lms.course_service.model.Course;

import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course, Long> {
    Optional<Course> findByCourseName(String courseName);
}
