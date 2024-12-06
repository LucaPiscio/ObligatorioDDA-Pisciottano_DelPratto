package com.obligatoriodda.obligatoriodda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obligatoriodda.obligatoriodda.Entity.Venta;

public interface VideoJuegosRepository extends JpaRepository<Venta, Integer> {
    
}
