package org.example.microservice_courses.Course.domain;

import org.example.microservice_courses.Course.infrastructure.CourseRepository;
import org.example.microservice_courses.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
    }

    public List<Course> getCoursesByProfessor(Long professorId) {
        return courseRepository.findByProfessors_Id(professorId);
    }

    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) throw new ResourceNotFoundException("Course not found");
        courseRepository.deleteById(id);
    }

    public Course updateCourse(Long id, Course course) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty()) throw new ResourceNotFoundException("Course not found");
        course.setId_course(id);
        courseRepository.save(course);
        return course;
    }
}
