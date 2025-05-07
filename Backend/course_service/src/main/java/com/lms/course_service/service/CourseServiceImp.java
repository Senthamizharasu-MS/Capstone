package com.lms.course_service.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.lms.course_service.exception.CourseNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.course_service.dto.CourseDto;
import com.lms.course_service.model.Course;
import com.lms.course_service.repo.CourseRepo;

@Service
@Transactional
public class CourseServiceImp implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<CourseDto> getAllCourses() {
        return courseRepo.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto getCourseById(Long id) {
        return courseRepo.findById(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID: " + id));
    }

    @Override
    public CourseDto getCourseByName(String courseName) {
        return courseRepo.findByCourseName(courseName)
                .map(this::mapToDto)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with title: " + courseName));
    }

    @Transactional
    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        Course course = mapToEntity(courseDto);
        Course savedCourse = courseRepo.save(course);
        return mapToDto(savedCourse);
    }

    @Transactional
    @Override
    public CourseDto updateCourse(Long id, CourseDto courseDto) {
        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID: " + id));

        course.setCourseName(courseDto.courseName());
        course.setCourseCode(courseDto.courseCode());
        course.setDescription(courseDto.description());
        course.setCourseCategory(courseDto.courseCategory());
        course.setCourseContent(courseDto.courseContent());
        course.setStartingDate(courseDto.startingDate());
        course.setEndingDate(courseDto.endingDate());
        course.setStatus(getCourseStatus(courseDto.status()));
        Course updatedCourse = courseRepo.save(course);
        return mapToDto(updatedCourse);
    }

    @Transactional
    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID: " + id));
        courseRepo.delete(course);
    }

    private CourseDto mapToDto(Course course) {
        return new CourseDto(
                course.getId(),
                course.getCourseName(),
                course.getCourseCode(),
                course.getDescription(),
                course.getCourseCategory(),
                course.getCourseContent(),
                course.getStartingDate(),
                course.getEndingDate(),
                course.getStatus().name());
    }

    private Course mapToEntity(CourseDto dto) {
        Course course = new Course();
        course.setCourseName(dto.courseName());
        course.setCourseCode(dto.courseCode());
        course.setDescription(dto.description());
        course.setCourseCategory(dto.courseCategory());
        course.setCourseContent(dto.courseContent());
        course.setStartingDate(dto.startingDate());
        course.setEndingDate(dto.endingDate());
        course.setStatus(getCourseStatus(dto.status()));
        return course;
    }

    private Course.CourseStatus getCourseStatus(String status) {
        return Arrays.stream(Course.CourseStatus.values())
                .filter(courseStatus -> courseStatus.name().equals(status))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid course status: " + status));
    }
}
