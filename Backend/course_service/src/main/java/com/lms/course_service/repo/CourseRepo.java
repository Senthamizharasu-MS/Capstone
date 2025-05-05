package com.lms.course_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lms.course_service.model.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {

}
