package com.obligatoriodda.obligatoriodda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obligatoriodda.obligatoriodda.Entity.Usuario;;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
