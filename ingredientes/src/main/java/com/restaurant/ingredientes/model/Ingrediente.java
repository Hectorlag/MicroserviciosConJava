
package com.restaurant.ingredientes.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Ingrediente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ingrediente;
    
    @NotBlank(message = "El nombre del ingrediente no puede estar vacío")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "El nombre del ingrediente solo puede contener letras y espacios")
    private String nombre_ingrediente;
    //la lista de platos es únicamente de los nombres de los mismos
    @ElementCollection(fetch = FetchType.EAGER)
    @NotNull(message = "La lista de platos no puede ser nula")
    @Size(min = 1, message = "Debe haber al menos un plato asociado")
    private List<String> platos;
}
