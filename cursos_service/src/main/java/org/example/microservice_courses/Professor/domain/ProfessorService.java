package org.example.microservice_courses.Professor.domain;

import org.example.microservice_courses.Professor.infrastructure.ProfessorRepository;
import org.example.microservice_courses.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> getAllProfessors(){
        return professorRepository.findAll();
    }

    public Professor getProfessorById(Long id){
        return professorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Professor not found with id " + id));
    }

    public Professor getProfessorByEmail(String email){
        return professorRepository.findByEmail(email)
                .orElseThrow(()-> new ResourceNotFoundException("Professor not found with email " + email));
    }

    public void deleteProfessor(Long id){
        professorRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Professor not found with id" + id));
        professorRepository.deleteById(id);

    }

    public Professor updateProfessor(Long id, Professor updatedProfessor){
        Professor professor = professorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Professor not found with id " + id));
        professor.setEmail(updatedProfessor.getEmail());
        professor.setNombre(updatedProfessor.getNombre());

        return professorRepository.save(professor);
    }

    public Professor createProfessor(Professor professor){
        return professorRepository.save(professor);
    }

}
