package Entity;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

public class Videojuegos {

    @Id
    private int Codigo;

    private String Nombre;

    private String Descripcion;

    private Double Precio;

    private int CantCopias;

    private String Categoria;
    
}
