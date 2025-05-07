package com.lms.course_service.service;

import java.util.List;
import com.lms.course_service.dto.CourseDto;

public interface CourseService {
    
    List<CourseDto> getAllCourses();
    CourseDto getCourseById(Long id);
    CourseDto getCourseByName(String courseName);
    CourseDto createCourse(CourseDto courseDto);
    CourseDto updateCourse(Long id, CourseDto courseDto);
    void deleteCourse(Long id);
}

