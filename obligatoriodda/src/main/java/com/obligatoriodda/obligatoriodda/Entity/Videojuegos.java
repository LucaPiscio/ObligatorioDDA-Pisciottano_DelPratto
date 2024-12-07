package com.obligatoriodda.obligatoriodda.Entity;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Videojuegos {

    @Id
    private int Codigo;

    private String Nombre;

    private String Descripcion;

    private Double Precio;

    private int Stock;

    private String Categoria;

    @ManyToMany(mappedBy = "videojuegosVendidos")
    private Set<VentaPremium> ventaspremium = new HashSet<>();

    @ManyToMany(mappedBy = "videojuegosVendidos")
    private Set<VentaRegular> ventasregular = new HashSet<>();

    public Videojuegos() {
    }

    public Videojuegos(String nombre, String descripcion, Double precio, int stock, String categoria) {
        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.Precio = precio;
        this.Stock = stock;
        this.Categoria = categoria;
    }

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

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        this.Precio = precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        this.Stock = stock;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        this.Categoria = categoria;
    }

    public Set<VentaPremium> getVentasPremium() {
        return ventaspremium;
    }

    public void setVentasPremium(Set<VentaPremium> ventaspremium) {
        this.ventaspremium = ventaspremium;
    }

    public Set<VentaRegular> getVentasRegular() {
        return ventasregular;
    }

    public void setVentasRegualar(Set<VentaRegular> ventasregular) {
        this.ventasregular = ventasregular;
    }


}
