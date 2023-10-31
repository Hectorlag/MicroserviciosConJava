
package com.restaurant.plato.controller;

import com.restaurant.plato.DTO.PlatoDTO;
import com.restaurant.plato.model.Plato;
import com.restaurant.plato.service.iPlatoService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/platos")
public class PlatoController {
    
    @Autowired
    private iPlatoService platoServ;
    
    //Obtengo la lista de platos
    @GetMapping("/traer")
    public List<Plato> getPlato(){
      return platoServ.getPlatos();
    }
    
    //Creo un nuevo plato
    @PostMapping("/crear")
    public ResponseEntity<?> crearPlato(@Valid @RequestBody PlatoDTO pla, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<String> errores = bindingResult.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errores);
        
        }
        
       platoServ.savePlato(pla.getNombre(), pla.getPrecio(), pla.getDescripcion());
       
       return ResponseEntity.status(HttpStatus.CREATED).body("Plato creado correctamente");
    }
    
    //Borrar un plato
    @DeleteMapping("/borrar/{id}")
     public String deletePlato(@PathVariable Long id){
         
         platoServ.deletePlato(id);
         return "Plato eliminado";        
    }
     
     //Editar plato
     @PutMapping("/editar/{id_original}")
     public Plato editarPlato(@PathVariable Long id_original, @RequestBody Plato p){
       
         platoServ.editPlato(id_original, p);
         Plato platoEditado = platoServ.findPlato(id_original);
         return platoEditado;
     }
     
     @GetMapping("/traer/{id}")
     public Plato traerUno(@PathVariable Long id){
         return platoServ.findPlato(id);
     }
    
    
    
    
    
}
