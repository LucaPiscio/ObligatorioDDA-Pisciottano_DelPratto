package com.obligatoriodda.obligatoriodda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obligatoriodda.obligatoriodda.Entity.Videojuegos;

public interface VideoJuegosRepository extends JpaRepository<Videojuegos, Integer> {
    
}
