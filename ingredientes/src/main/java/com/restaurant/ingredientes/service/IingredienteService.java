
package com.restaurant.ingredientes.service;

import com.restaurant.ingredientes.model.Ingrediente;
import java.util.List;


public interface IingredienteService {
    
    //Obtengo todos los ingredientes
    public List<Ingrediente> getIngredientes();
    
    //Guardo un ingrediente
    public void saveIngrediente(Ingrediente in);
    
    //Elimno un ingrediente
    public void deleteIngrediente(Long id);
    
    //Edito un ingrediente
    public void editIngrediente(Long id, Ingrediente in);
    
    //Busco un ingrediente
    public Ingrediente findIngrediente(Long id);

    public List<Ingrediente> getIngredienteByPlato(String nombrePlato);
    
    
    
}
