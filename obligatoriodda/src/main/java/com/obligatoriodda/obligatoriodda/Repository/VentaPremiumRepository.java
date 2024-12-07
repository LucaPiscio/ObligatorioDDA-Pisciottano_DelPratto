package com.obligatoriodda.obligatoriodda.Repository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.obligatoriodda.obligatoriodda.Entity.VentaPremium;;

public interface VentaPremiumRepository extends JpaRepository<VentaPremium, Integer> {
    public List<VentaPremium> findByfCompra(LocalDate pfCompra);
}
