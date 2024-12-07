package com.obligatoriodda.obligatoriodda.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class VentaRegular extends Venta{

    @ManyToOne
    @JoinColumn(name = "idUsuarioRegular", referencedColumnName = "Codigo")
    private Uregular uregular; 
    
    
    public Uregular getUregular() {
        return uregular;
    }

    public void setUregular(Uregular uregular) {
        this.uregular = uregular;
    }

}
