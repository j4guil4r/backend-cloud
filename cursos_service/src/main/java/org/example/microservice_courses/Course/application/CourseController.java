package org.example.microservice_courses.Course.application;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.microservice_courses.Course.domain.Course;
import org.example.microservice_courses.Course.domain.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Obtener todos los cursos
    @Operation(summary = "Obtener todos los cursos", description = "Devuelve una lista con todos los cursos registrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de cursos obtenida exitosamente"),
            @ApiResponse(responseCode = "404", description = "No se encontraron cursos")
    })
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    // Obtener curso por ID
    @Operation(summary = "Obtener un curso por ID", description = "Devuelve un curso específico basado en su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso obtenido exitosamente"),
            @ApiResponse(responseCode = "404", description = "Curso no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    // Crear un nuevo curso
    @Operation(summary = "Crear un nuevo curso", description = "Crea un nuevo curso.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Curso creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = courseService.createCourse(course);
        return ResponseEntity.ok(createdCourse);
    }

    // Actualizar un curso por ID
    @Operation(summary = "Actualizar un curso", description = "Actualiza un curso específico basado en su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Curso no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        Course updatedCourse = courseService.updateCourse(id, course);
        return ResponseEntity.ok(updatedCourse);
    }

    // Eliminar un curso por ID
    @Operation(summary = "Eliminar un curso", description = "Elimina un curso específico basado en su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Curso no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
