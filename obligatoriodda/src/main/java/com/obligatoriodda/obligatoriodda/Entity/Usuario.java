package com.obligatoriodda.obligatoriodda.Entity;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.MappedSuperclass;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@MappedSuperclass
public class Usuario{
    @Id
    private int Codigo;

    private String Nombre;

    private String Email;

    private LocalDate Fregistro;

    public Usuario() {
    }

    public Usuario(String nombre, String email, LocalDate fRegistro) {
        this.Nombre = nombre;
        this.Email = email;
        this.Fregistro = fRegistro;
    }

    // Getters y Setters
    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        this.Codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public LocalDate getFRegistro() {
        return Fregistro;
    }

    public void setFRegistro(LocalDate fRegistro) {
        this.Fregistro = fRegistro;
    }


}