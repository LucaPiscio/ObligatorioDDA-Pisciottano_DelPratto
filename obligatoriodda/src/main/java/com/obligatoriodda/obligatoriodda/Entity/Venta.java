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
    private int Codigo; 
    private String NombreJuego;
    private int Cantidad;
    private LocalDate fCompra;  
    private Double total; 

    @ManyToOne
    @JoinColumn(name = "idVideoJuegos", referencedColumnName = "Codigo")
    private Videojuegos videojuegos; 

    @ManyToMany
    private Set<Videojuegos> videojuegosVendidos = new HashSet<>(); 

    public Venta() {
    }

    public Venta(LocalDate fCompra, Double total, Set<Videojuegos> videojuegosVendidos,String nombreJuego,int cantidad) {
        this.Cantidad=cantidad;
        this.NombreJuego=nombreJuego;
        this.fCompra = fCompra;
        this.total = total;
        this.videojuegosVendidos = videojuegosVendidos;
    }

 
    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        this.Codigo = codigo;
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

    public String getNombreJuego() {
        return NombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.NombreJuego = nombreJuego;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        this.Cantidad = cantidad;
    }

    
    public Videojuegos getVideoJuego() {
        return videojuegos;
    }

    public void setVideoJuego(Videojuegos videojuegos) {
        this.videojuegos = videojuegos;
    }

}
