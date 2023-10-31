
package com.restaurant.plato.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {
    
    @NotBlank(message = "El nombre del plato no puede estar vacío")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "El nombre del plato solo puede contener letras y espacios")
    private String nombre;
    
    @DecimalMin(value = "0.0", inclusive = true, message = "El valor debe ser mayor o igual a 0")
    private Double precio;
    private String descripcion;
}
