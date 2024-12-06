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
import com.obligatoriodda.obligatoriodda.Entity.Uregular;
import com.obligatoriodda.obligatoriodda.Repository.RegularRepository;

@RestController
@RequestMapping("/UsuariosRegular")
@CrossOrigin(origins = "http://localhost:3000")
public class RegularController {
    @Autowired
    private RegularRepository regularRepository;

      @PostMapping
    public ResponseEntity<?> altaUsuarioRegular(@RequestBody Uregular uregular){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(regularRepository.save(uregular));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @PutMapping
    public ResponseEntity<?> modificacionUsuarioRegular(@RequestBody Uregular uregular){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(regularRepository.save(uregular));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @DeleteMapping("/{Codigo}")
    public ResponseEntity<?> eliminacionUsuarioRegular(@PathVariable int Codigo){
        try {
            regularRepository.deleteById(Codigo);
            return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @GetMapping("/{Codigo}")
    public ResponseEntity<?> conseguirUsuarioRegular(@PathVariable int Codigo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(regularRepository.findById(Codigo));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @GetMapping
    public ResponseEntity<?> conseguirUsuariosRegular(){
        try {
            
            return ResponseEntity.status(HttpStatus.OK).body(regularRepository.findAll());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }
}
