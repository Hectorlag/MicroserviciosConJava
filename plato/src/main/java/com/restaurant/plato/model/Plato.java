
package com.restaurant.plato.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Plato {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_plato;
    @NotBlank(message = "El nombre del plato no puede estar vacío")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "El nombre del plato solo puede contener letras y espacios")
    private String nombre;
    private double precio;
    private String descripcion;
    @ElementCollection(fetch = FetchType.EAGER)//carga ansiosa
    private List<String> listaIngredientes;
    
     
    
}
