package com.lms.course_service.controller;

import java.util.List;
import java.util.stream.Collectors;
import com.lms.course_service.dto.CourseResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lms.course_service.dto.CourseDto;
import com.lms.course_service.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseResponseDto> getAllCourses() {
        return courseService.getAllCourses()
                .stream()
                .map(course -> new CourseResponseDto(
                        course.id(),
                        course.courseName(),
                        course.courseCode(),
                        course.description(),
                        course.startingDate(),
                        course.endingDate()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CourseResponseDto getCourseById(@PathVariable Long id) {
        CourseDto courseDto = courseService.getCourseById(id);
        return new CourseResponseDto(
                courseDto.id(),
                courseDto.courseName(),
                courseDto.courseCode(),
                courseDto.description(),
                courseDto.startingDate(),
                courseDto.endingDate());
    }

    @PostMapping
    public CourseResponseDto createCourse(@Valid @RequestBody CourseDto courseDto) {
        CourseDto createdCourse = courseService.createCourse(courseDto);
        return new CourseResponseDto(
                createdCourse.id(),
                createdCourse.courseName(),
                createdCourse.courseCode(),
                createdCourse.description(),
                createdCourse.startingDate(),
                createdCourse.endingDate());
    }

    @PutMapping("/{id}")
    public CourseResponseDto updateCourse(@PathVariable Long id, @Valid @RequestBody CourseDto courseDto) {
        CourseDto updatedCourse = courseService.updateCourse(id, courseDto);
        return new CourseResponseDto(
                updatedCourse.id(),
                updatedCourse.courseName(),
                updatedCourse.courseCode(),
                updatedCourse.description(),
                updatedCourse.startingDate(),
                updatedCourse.endingDate());
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}