package com.obligatoriodda.obligatoriodda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obligatoriodda.obligatoriodda.Entity.Uregular;;

public interface RegularRepository extends JpaRepository<Uregular, Integer> {
    
}
