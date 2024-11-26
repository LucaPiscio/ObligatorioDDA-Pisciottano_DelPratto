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
public class Venta {
    @Id
    private int Codigo;

    @ManyToOne
    @JoinColumn(name="idUsuario", referencedColumnName = "id")
    private Usuario usuario;

    private LocalDate FCompra;

    private Double Total;

    @ManyToOne
    @JoinColumn(name="idVideojuego", referencedColumnName = "id")
    private Set<Videojuegos> videojuegosVendidos = new HashSet<>();

    public Venta() {
    }

 
    public Venta(Usuario usuario, LocalDate fCompra, Double total, Set<Videojuegos> videojuegosVendidos) {
        this.usuario = usuario;
        this.FCompra = fCompra;
        this.Total = total;
        this.videojuegosVendidos = videojuegosVendidos;
    }

    // Getters y Setters
    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        this.Codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFCompra() {
        return FCompra;
    }

    public void setFCompra(LocalDate fCompra) {
        this.FCompra = fCompra;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double total) {
        this.Total = total;
    }

    public Set<Videojuegos> getVideojuegosVendidos() {
        return videojuegosVendidos;
    }

    public void setVideojuegosVendidos(Set<Videojuegos> videojuegosVendidos) {
        this.videojuegosVendidos = videojuegosVendidos;
    }
}
