package org.example.microservice_courses.Course.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.microservice_courses.Professor.domain.Professor;

import java.util.List;

@Entity
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_course;

    @Column(nullable = false)
    private String course_name;

    @Column(nullable = false)
    private String course_description;

    @Column(nullable = false)
    private int id_career;

    @ManyToMany
    @JoinTable(
            name = "course_professor",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    private List<Professor> professors;
}
