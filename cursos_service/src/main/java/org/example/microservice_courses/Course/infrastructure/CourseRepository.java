package org.example.microservice_courses.Course.infrastructure;

import org.example.microservice_courses.Course.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByProfessors_Id(Long professorId);
}
