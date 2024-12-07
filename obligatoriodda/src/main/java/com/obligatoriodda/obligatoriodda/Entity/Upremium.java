package com.obligatoriodda.obligatoriodda.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Upremium extends Usuario{
    private Double descuento;      
    private LocalDate FechaExpiracion; 
    private LocalDate Fmembresia;


    public Upremium() {
    }
    public Upremium(Double descuento, LocalDate fechaexpiracion,LocalDate fmembresia) {
        this.descuento = descuento;
        this.FechaExpiracion = fechaexpiracion;
        this.Fmembresia = fmembresia;
    }


    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public LocalDate getFechaExpiracion() {
        return FechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaexpiracion) {
        this.FechaExpiracion = fechaexpiracion;
    }

    public LocalDate getFmembresia() {
        return Fmembresia;
    }

    public void setFmembresia(LocalDate fmembresia) {
        this.Fmembresia = fmembresia;
    }
}
