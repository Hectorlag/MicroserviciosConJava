
package com.restaurant.ingredientes.service;

import com.restaurant.ingredientes.model.Ingrediente;
import com.restaurant.ingredientes.repository.IingredienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService implements IingredienteService{
    
    @Autowired
    private IingredienteRepository ingreRepo;
    
    @Override
    public List<Ingrediente> getIngredientes() {
       return ingreRepo.findAll();
    }

    @Override
    public void saveIngrediente(Ingrediente in) {
        ingreRepo.save(in);
    }

    @Override
    public void deleteIngrediente(Long id) {
        ingreRepo.deleteById(id);
    }

    @Override
    public void editIngrediente(Long id, Ingrediente in) {
        Ingrediente ingre = this.findIngrediente(id);
        ingre.setNombre_ingrediente(in.getNombre_ingrediente());
        ingre.setPlatos(in.getPlatos());
        
        ingreRepo.save(ingre);
    }

    @Override
    public Ingrediente findIngrediente(Long id) {
        return ingreRepo.findById(id).orElse(null);
    }

    @Override
    public List<Ingrediente> getIngredienteByPlato(String nombrePlato) {
        return ingreRepo.findByNombre(nombrePlato);
    }
    
    
}
