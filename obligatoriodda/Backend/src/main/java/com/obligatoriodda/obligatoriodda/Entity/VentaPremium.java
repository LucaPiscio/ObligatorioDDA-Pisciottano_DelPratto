package com.obligatoriodda.obligatoriodda.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class VentaPremium extends Venta{
    @ManyToOne
    @JoinColumn(name = "idUsuarioPremium", referencedColumnName = "Codigo")
    private Upremium upremium; 

    public Upremium getUpremium() {
        return upremium;
    }

    public void setUpremium(Upremium upremium) {
        this.upremium = upremium;
    }
}
