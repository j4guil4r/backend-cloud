package org.example.microservice_courses.Professor.application;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.microservice_courses.Professor.domain.Professor;
import org.example.microservice_courses.Professor.domain.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    // Obtener todos los profesores
    @Operation(summary = "Obtener todos los profesores", description = "Devuelve una lista con todos los profesores registrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de profesores obtenida exitosamente"),
            @ApiResponse(responseCode = "404", description = "No se encontraron profesores")
    })
    @GetMapping
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    // Obtener profesor por ID
    @Operation(summary = "Obtener un profesor por ID", description = "Devuelve un profesor específico basado en su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profesor obtenido exitosamente"),
            @ApiResponse(responseCode = "404", description = "Profesor no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id) {
        Professor professor = professorService.getProfessorById(id);
        return ResponseEntity.ok(professor);
    }

    // Obtener profesor por Email
    @Operation(summary = "Obtener un profesor por Email", description = "Devuelve un profesor específico basado en su email.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profesor obtenido exitosamente"),
            @ApiResponse(responseCode = "404", description = "Profesor no encontrado")
    })
    @GetMapping("/by-email/{email}")
    public ResponseEntity<Professor> getProfessorByEmail(@PathVariable String email) {
        Professor professor = professorService.getProfessorByEmail(email);
        return ResponseEntity.ok(professor);
    }

    // Crear un nuevo profesor
    @Operation(summary = "Crear un nuevo profesor", description = "Crea un nuevo profesor.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Profesor creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor) {
        Professor createdProfessor = professorService.createProfessor(professor);
        return ResponseEntity.ok(createdProfessor);
    }

    // Actualizar un profesor por ID
    @Operation(summary = "Actualizar un profesor", description = "Actualiza un profesor específico basado en su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profesor actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Profesor no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        Professor updatedProfessor = professorService.updateProfessor(id, professor);
        return ResponseEntity.ok(updatedProfessor);
    }

    // Eliminar un profesor por ID
    @Operation(summary = "Eliminar un profesor", description = "Elimina un profesor específico basado en su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profesor eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Profesor no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
        return ResponseEntity.noContent().build();
    }
}
