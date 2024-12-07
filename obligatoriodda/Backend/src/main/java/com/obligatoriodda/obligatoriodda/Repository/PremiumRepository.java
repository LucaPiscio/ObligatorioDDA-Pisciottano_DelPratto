package com.obligatoriodda.obligatoriodda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obligatoriodda.obligatoriodda.Entity.Upremium;;

public interface PremiumRepository extends JpaRepository<Upremium, Integer> {
    
}
