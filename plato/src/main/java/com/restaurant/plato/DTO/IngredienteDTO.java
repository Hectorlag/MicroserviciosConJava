
package com.restaurant.plato.DTO;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredienteDTO {
    
   private Long id_ingrediente;
   private String nombre_ingrediente;
   private List<String> platos;
}
