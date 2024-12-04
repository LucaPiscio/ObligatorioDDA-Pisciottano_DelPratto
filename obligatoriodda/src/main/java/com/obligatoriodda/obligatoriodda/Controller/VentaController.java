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

import com.obligatoriodda.obligatoriodda.Entity.Usuario;
import com.obligatoriodda.obligatoriodda.Repository.UsuarioRepository;
import com.obligatoriodda.obligatoriodda.Entity.Venta;
import com.obligatoriodda.obligatoriodda.Repository.VentaRepository;

@RestController
@RequestMapping("/ventas")
@CrossOrigin(origins = "http://localhost:3000")

public class VentaController {
    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> altaVenta(@RequestBody Venta venta){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventaRepository.save(venta));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @PutMapping
    public ResponseEntity<?> modificacionVenta(@RequestBody Venta venta){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventaRepository.save(venta));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @DeleteMapping("/{Codigo}")
    public ResponseEntity<?> eliminacionCenta(@PathVariable int Codigo){
        try {
            ventaRepository.deleteById(Codigo);
            return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }
    
    @GetMapping("/{Codigo}")
    public ResponseEntity<?> conseguirLibro(@PathVariable int Codigo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventaRepository.findById(Codigo));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }
    
    @GetMapping
    public ResponseEntity<?> conseguirVentas(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventaRepository.findAll());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @PutMapping("/{Codigo}/asignarUsuario/{idUsuario}")
    public ResponseEntity<?> asignarBiblioteca(@PathVariable int Codigo, @PathVariable int idUsuario){
    try {
        Usuario usuario;
        Venta venta;
        if(usuarioRepository.existsById(idUsuario))
            usuario = usuarioRepository.findById(idUsuario).get();
        else
            throw new Exception();
        if(ventaRepository.existsById(Codigo))
            venta = ventaRepository.findById(Codigo).get();
        else
            throw new Exception();
        
        venta.setUsuario(usuario);
        ventaRepository.save(venta);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario asignado");
    }
    catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
    }
    }

     @GetMapping("/filtrarPorFecha")
    public ResponseEntity<?> conseguirVentaPorFecha(@RequestParam LocalDate FCompra){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventaRepository.findByFCompra(FCompra));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

}
