package com.obligatoriodda.obligatoriodda.Controller;
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
import org.springframework.web.bind.annotation.RestController;
import com.obligatoriodda.obligatoriodda.Entity.Upremium;
import com.obligatoriodda.obligatoriodda.Repository.PremiumRepository;

@RestController
@RequestMapping("/UsuariosPremium")
@CrossOrigin(origins = "http://localhost:3000")
public class PremiumController {
    @Autowired
    private PremiumRepository premiumRepository;

     @PostMapping
    public ResponseEntity<?> altaUsuarioPremium(@RequestBody Upremium upremium){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(premiumRepository.save(upremium));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @PutMapping
    public ResponseEntity<?> modificacionUsuarioPremium(@RequestBody Upremium upremium){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(premiumRepository.save(upremium));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @DeleteMapping("/{Codigo}")
    public ResponseEntity<?> eliminacionUsuarioPremium(@PathVariable int Codigo){
        try {
            premiumRepository.deleteById(Codigo);
            return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @GetMapping("/{Codigo}")
    public ResponseEntity<?> conseguirUsuarioPremium(@PathVariable int Codigo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(premiumRepository.findById(Codigo));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @GetMapping
    public ResponseEntity<?> conseguirUsuariosPremium(){
        try {
            
            return ResponseEntity.status(HttpStatus.OK).body(premiumRepository.findAll());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }
}
