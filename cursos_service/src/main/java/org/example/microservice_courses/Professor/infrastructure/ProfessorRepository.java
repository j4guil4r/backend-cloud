package org.example.microservice_courses.Professor.infrastructure;

import org.example.microservice_courses.Professor.domain.Professor;
import org.example.microservice_courses.Professor.domain.ProfessorService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Optional<Professor> findByEmail(String email);
}
