package org.example.microservice_courses.Professor.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.microservice_courses.Course.domain.Course;

import java.util.List;

@Entity
@Getter
@Setter
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column(unique = true)
    private String email;

    @ManyToMany(mappedBy = "professors")
    private List<Course> courses;
}
