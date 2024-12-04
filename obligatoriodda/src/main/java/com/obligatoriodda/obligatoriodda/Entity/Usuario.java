package com.obligatoriodda.obligatoriodda.Entity;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Usuario{
    @Id
    private int Codigo;

    private String Nombre;

    private String Email;

    private LocalDate Fregistro;

    private String Membresia;

    private LocalDate Fmembresia;

    public Usuario() {
    }

    public Usuario(String nombre, String email, LocalDate fRegistro,String membresia,LocalDate fmembresia) {
        this.Nombre = nombre;
        this.Email = email;
        this.Fregistro = fRegistro;
        this.Membresia = membresia;
        this.Fmembresia = fmembresia;
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

    public String getmembresia() {
        return Membresia;
    }

    public void setMembresia(String membresia) {
        this.Membresia = membresia;
    }

    public LocalDate getFmembresia() {
        return Fmembresia;
    }

    public void setFmembresia(LocalDate fmembresia) {
        this.Fmembresia = fmembresia;
    }

}