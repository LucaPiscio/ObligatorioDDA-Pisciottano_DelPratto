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

    private int CantCopias;

    private String Categoria;

    @ManyToMany(mappedBy = "videojuegosVendidos")
    private Set<Venta> ventas = new HashSet<>();

    public Videojuegos() {
    }

    public Videojuegos(String nombre, String descripcion, Double precio, int cantCopias, String categoria) {
        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.Precio = precio;
        this.CantCopias = cantCopias;
        this.Categoria = categoria;
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

    public int getCantCopias() {
        return CantCopias;
    }

    public void setCantCopias(int cantCopias) {
        this.CantCopias = cantCopias;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        this.Categoria = categoria;
    }

    public Set<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }
}
