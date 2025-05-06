package com.lms.course_service.service;

import java.util.List;
import java.util.stream.Collectors;

import com.lms.course_service.exception.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.course_service.dto.CourseDto;
import com.lms.course_service.model.Course; 
import com.lms.course_service.repo.CourseRepo;

@Service
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
                .orElseThrow(() -> new CourseNotFoundException(id)); // Throw exception if not found
    }

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        Course course = mapToEntity(courseDto);
        Course savedCourse = courseRepo.save(course);
        return mapToDto(savedCourse);
    }

    @Override
    public CourseDto updateCourse(Long id, CourseDto courseDto) {
        return courseRepo.findById(id)
                .map(course -> {
                    course.setCourseName(courseDto.courseName());
                    course.setCourseCode(courseDto.courseCode());
                    course.setDescription(courseDto.description());
                    course.setStartingDate(courseDto.startingDate());
                    course.setEndingDate(courseDto.endingDate());
                    Course updatedCourse = courseRepo.save(course);
                    return mapToDto(updatedCourse);
                })
                .orElse(null);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }

    private CourseDto mapToDto(Course course) {
        return new CourseDto(
                course.getId(),
                course.getCourseName(),
                course.getCourseCode(),
                course.getDescription(),
                course.getStartingDate(),
                course.getEndingDate());
    }

    private Course mapToEntity(CourseDto dto) {
        Course course = new Course();
        course.setCourseName(dto.courseName());
        course.setCourseCode(dto.courseCode());
        course.setDescription(dto.description());
        course.setStartingDate(dto.startingDate());
        course.setEndingDate(dto.endingDate());
        return course;
    }
}
