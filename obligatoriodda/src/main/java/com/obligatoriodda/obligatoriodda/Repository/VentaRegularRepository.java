package com.obligatoriodda.obligatoriodda.Repository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.obligatoriodda.obligatoriodda.Entity.VentaRegular;;

public interface VentaRegularRepository extends JpaRepository<VentaRegular, Integer> {
    public List<VentaRegular> findByfCompra(LocalDate pfCompra);
}