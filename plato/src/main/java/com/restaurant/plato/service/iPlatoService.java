
package com.restaurant.plato.service;

import com.restaurant.plato.model.Plato;
import java.util.List;


public interface iPlatoService {
    
    public List<Plato> getPlatos();
    
    public void savePlato(String nombre, Double precio, String descripcion);
    
    public void deletePlato(Long id);
    
    public void editPlato(Long id, Plato p);
    
    public Plato findPlato(Long id);
    
}
