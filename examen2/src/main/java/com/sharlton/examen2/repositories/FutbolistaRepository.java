package com.sharlton.examen2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sharlton.examen2.models.Futbolista;

public interface FutbolistaRepository extends JpaRepository<Futbolista, Long> {
    public List<Futbolista> findByNombreContainingIgnoreCaseOrApellido1ContainingIgnoreCase(String nombre, String apellido1);
}