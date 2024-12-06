package com.obligatoriodda.obligatoriodda.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Upremium extends Usuario{
    private Double descuento;      
    private LocalDate fechaExpiracion; 
    private LocalDate Fmembresia;


    public Upremium() {
    }
    public Upremium(Double descuento, LocalDate fechaExpiracion,LocalDate fmembresia) {
        this.descuento = descuento;
        this.fechaExpiracion = fechaExpiracion;
        this.Fmembresia = fmembresia;
    }


    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public LocalDate getFmembresia() {
        return Fmembresia;
    }

    public void setFmembresia(LocalDate fmembresia) {
        this.Fmembresia = fmembresia;
    }
}
