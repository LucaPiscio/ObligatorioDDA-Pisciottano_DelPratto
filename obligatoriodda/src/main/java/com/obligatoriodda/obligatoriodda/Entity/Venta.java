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
public class Venta {

    @Id
    private int codigo; 

    private LocalDate fCompra;  
    private Double total; 

    @ManyToMany
    private Set<Videojuegos> videojuegosVendidos = new HashSet<>(); 

    public Venta() {
    }

    public Venta( LocalDate fCompra, Double total, Set<Videojuegos> videojuegosVendidos) {
        this.fCompra = fCompra;
        this.total = total;
        this.videojuegosVendidos = videojuegosVendidos;
    }

 
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFCompra() {
        return fCompra;
    }

    public void setFCompra(LocalDate fCompra) {
        this.fCompra = fCompra;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Set<Videojuegos> getVideojuegosVendidos() {
        return videojuegosVendidos;
    }

    public void setVideojuegosVendidos(Set<Videojuegos> videojuegosVendidos) {
        this.videojuegosVendidos = videojuegosVendidos;
    }
}
