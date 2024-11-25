package com.obligatoriodda.obligatoriodda.Entity;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

public class Venta {
    @Id
    private int Codigo;

    private Usuario usuario;

    private LocalDate FCompra;

    private Double Total;


}
