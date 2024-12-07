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
import com.obligatoriodda.obligatoriodda.Entity.Upremium;
import com.obligatoriodda.obligatoriodda.Repository.PremiumRepository;
import com.obligatoriodda.obligatoriodda.Entity.Videojuegos;
import com.obligatoriodda.obligatoriodda.Repository.VentaPremiumRepository;
import com.obligatoriodda.obligatoriodda.Repository.VideoJuegosRepository;
import com.obligatoriodda.obligatoriodda.Entity.VentaPremium;
import com.obligatoriodda.obligatoriodda.Entity.VentaRegular;
import com.obligatoriodda.obligatoriodda.Entity.Videojuegos;



@RestController
@RequestMapping("/ventasPremium")
@CrossOrigin(origins = "http://localhost:3000")
public class VentaPremiumController {
    
     @Autowired
    private VentaPremiumRepository ventapremiumRepository;

    @Autowired
    private PremiumRepository premiumRepository;

    @Autowired
    private VideoJuegosRepository videojuegosRepository;


    @PostMapping
    public ResponseEntity<?> altaVentaPremium(@RequestBody VentaPremium ventapremium){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventapremiumRepository.save(ventapremium));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @PutMapping
    public ResponseEntity<?> modificacionVentaPremium(@RequestBody VentaPremium ventapremium){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventapremiumRepository.save(ventapremium));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @DeleteMapping("/{Codigo}")
    public ResponseEntity<?> eliminacionVentaPremium(@PathVariable int Codigo){
        try {
            ventapremiumRepository.deleteById(Codigo);
            return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }
    
    @GetMapping("/{Codigo}")
    public ResponseEntity<?> conseguirVentaPremium(@PathVariable int Codigo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventapremiumRepository.findById(Codigo));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }
    
    @GetMapping
    public ResponseEntity<?> conseguirVentasPremium(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventapremiumRepository.findAll());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @PutMapping("/{Codigo}/asignarUsuario/{idUsuario}")
    public ResponseEntity<?> asignarUsuarioPremium(@PathVariable int Codigo, @PathVariable int idUsuario){
    try {
        Upremium upremium;
        VentaPremium ventapremium;
        if(premiumRepository.existsById(idUsuario))
            upremium = premiumRepository.findById(idUsuario).get();
        else
            throw new Exception();
        if(ventapremiumRepository.existsById(Codigo))
            ventapremium = ventapremiumRepository.findById(Codigo).get();
        else
            throw new Exception();
        
        ventapremium.setUpremium(upremium);
        ventapremiumRepository.save(ventapremium);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario asignado");
    }
    catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
    }
    }

        @PutMapping("/{Codigo}/asignarVideoJuego/{idVideoJuegos}")
    public ResponseEntity<?> asignarVideoJuego(@PathVariable int Codigo, @PathVariable int idVideoJuegos){
    try {
        Videojuegos videojuegos;
        VentaPremium ventapremium;
        if(videojuegosRepository.existsById(idVideoJuegos))
            videojuegos = videojuegosRepository.findById(idVideoJuegos).get();
        else
            throw new Exception();
        if(ventapremiumRepository.existsById(Codigo))
            ventapremium = ventapremiumRepository.findById(Codigo).get();
        else
            throw new Exception();
        
        ventapremium.setVideoJuego(videojuegos);
        ventapremiumRepository.save(ventapremium);
        return ResponseEntity.status(HttpStatus.OK).body("VideoJuego asignado");
    }
    catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
    }
    }

     @GetMapping("/filtrarPorFecha")
    public ResponseEntity<?> conseguirVentaPorFecha(@RequestParam LocalDate fCompra){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventapremiumRepository.findByfCompra(fCompra));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

}
