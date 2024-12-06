package com.obligatoriodda.obligatoriodda.Controller;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.obligatoriodda.obligatoriodda.Entity.Uregular;
import com.obligatoriodda.obligatoriodda.Repository.RegularRepository;
import com.obligatoriodda.obligatoriodda.Repository.VentaRegularRepository;
import com.obligatoriodda.obligatoriodda.Entity.VentaRegular;

@RestController
@RequestMapping("/ventasRegular")
@CrossOrigin(origins = "http://localhost:3000")
public class VentaRegularController {

     @Autowired
    private VentaRegularRepository ventaregularRepository;

    @Autowired
    private RegularRepository regularRepository;

    @PostMapping
    public ResponseEntity<?> altaVentaRegular(@RequestBody VentaRegular ventaregular){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventaregularRepository.save(ventaregular));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @PutMapping
    public ResponseEntity<?> modificacionVentaRegular(@RequestBody VentaRegular ventaregular){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventaregularRepository.save(ventaregular));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @DeleteMapping("/{Codigo}")
    public ResponseEntity<?> eliminacionVentaRegular(@PathVariable int Codigo){
        try {
            ventaregularRepository.deleteById(Codigo);
            return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }
    
    @GetMapping("/{Codigo}")
    public ResponseEntity<?> conseguirVentaRegular(@PathVariable int Codigo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventaregularRepository.findById(Codigo));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }
    
    @GetMapping
    public ResponseEntity<?> conseguirVentasRegular(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventaregularRepository.findAll());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @PutMapping("/{Codigo}/asignarUsuario/{idUsuarioRegular}")
    public ResponseEntity<?> asignarUsuarioRegular(@PathVariable int Codigo, @PathVariable int idUsuario){
    try {
        Uregular uregular;
        VentaRegular ventaregular;
        if(regularRepository.existsById(idUsuario))
            uregular = regularRepository.findById(idUsuario).get();
        else
            throw new Exception();
        if(ventaregularRepository.existsById(Codigo))
            ventaregular = ventaregularRepository.findById(Codigo).get();
        else
            throw new Exception();
        
        ventaregular.setUregular(uregular);
        ventaregularRepository.save(ventaregular);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario asignado");
    }
    catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
    }
    }

     @GetMapping("/filtrarPorFecha")
    public ResponseEntity<?> conseguirVentaPorFecha(@RequestParam LocalDate fCompra){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventaregularRepository.findByfCompra(fCompra));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }
    
}
