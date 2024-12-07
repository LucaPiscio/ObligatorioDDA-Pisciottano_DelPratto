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
import com.obligatoriodda.obligatoriodda.Entity.Videojuegos;
import com.obligatoriodda.obligatoriodda.Repository.VideoJuegosRepository;


@RestController
@RequestMapping("/Videojuegos")
@CrossOrigin(origins = "http://localhost:3000")
public class VideoJuegosController {
      
    @Autowired
    private VideoJuegosRepository videoJuegosRepository;

        @PostMapping
    public ResponseEntity<?> altaVideojuegos(@RequestBody Videojuegos videoJuegos){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(videoJuegosRepository.save(videoJuegos));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @PutMapping
    public ResponseEntity<?> modificacionVideoJuegos(@RequestBody Videojuegos videoJuegos){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(videoJuegosRepository.save(videoJuegos));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @DeleteMapping("/{Codigo}")
    public ResponseEntity<?> eliminacionVideoJuegos(@PathVariable int Codigo){
        try {
            videoJuegosRepository.deleteById(Codigo);
            return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @GetMapping("/{Codigo}")
    public ResponseEntity<?> conseguirVideoJuegos(@PathVariable int Codigo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(videoJuegosRepository.findById(Codigo));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @GetMapping
    public ResponseEntity<?> conseguirVideoJuegos(){
        try {
            
            return ResponseEntity.status(HttpStatus.OK).body(videoJuegosRepository.findAll());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }
}
