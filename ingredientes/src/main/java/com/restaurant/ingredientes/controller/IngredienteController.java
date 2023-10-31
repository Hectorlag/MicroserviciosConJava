
package com.restaurant.ingredientes.controller;

import com.restaurant.ingredientes.model.Ingrediente;

import com.restaurant.ingredientes.service.IingredienteService;
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
@RequestMapping("/ingredientes")
public class IngredienteController {
    
    @Autowired
    private IingredienteService ingreServi;
    
    //Traer todos los ingredientes
    @GetMapping("/traer")
    public List<Ingrediente> getIngredientes(){
      return ingreServi.getIngredientes();
    }
   
    //Crear
    @PostMapping("/crear")                   //Valid=instruye a Spring para que valide el objeto
       public ResponseEntity<?> crearIngrediente(@Valid @RequestBody Ingrediente ingrediente, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errores = bindingResult.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errores);
        }

        ingreServi.saveIngrediente(ingrediente);
        return ResponseEntity.status(HttpStatus.CREATED).body(ingrediente);
    }
    
    //Borrar ingrediente
    @DeleteMapping("/borrar/{id}")
    public String borrarIngrediente(@PathVariable Long id){
     ingreServi.deleteIngrediente(id);
     return "Ingrediente eliminado";
    }
    
    //Editar ingrediente
    @PutMapping("/editar/{id_original}")
    public Ingrediente edith(@PathVariable Long id_original, @RequestBody Ingrediente ingre){
       
        ingreServi.editIngrediente(id_original, ingre);
        Ingrediente in = ingreServi.findIngrediente(id_original);
        return in;
    }
    
    @GetMapping ("/traer/{nombrePlato}")
    public List<Ingrediente> traerIngredientesByPlato (@PathVariable String nombrePlato) {
        return ingreServi.getIngredienteByPlato(nombrePlato);
    }
    
    
    
    
    
}
