
package com.restaurant.plato.service;

import com.restaurant.plato.DTO.IngredienteDTO;
import com.restaurant.plato.model.Plato;
import com.restaurant.plato.repository.iPlatoRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlatoService implements iPlatoService{
    
    @Autowired
    private iPlatoRepository platoRepo;
 
    //En este caso lo hice sin necesidad de clase AppConfig
    RestTemplate api = new RestTemplate();

    @Override
    public List<Plato> getPlatos() {
        return platoRepo.findAll();
    }

    @Override
    public void savePlato(String nombre, Double precio, String descripcion) {

        Plato plato = new Plato();
        List<String> listaIngrePlato = new ArrayList<String>();

        plato.setNombre(nombre);
        plato.setPrecio(precio);
        plato.setDescripcion(descripcion);

        List<IngredienteDTO> listaIngredientes = Arrays.asList(api.getForObject("http://localhost:9004/ingredientes/traer/" + nombre, IngredienteDTO[].class));

        for (IngredienteDTO ingre : listaIngredientes) {
            listaIngrePlato.add(ingre.getNombre_ingrediente());
        }  
        plato.setListaIngredientes(listaIngrePlato);

        platoRepo.save(plato);
    }

    @Override
    public void deletePlato(Long id) {
        platoRepo.deleteById(id);
    }

    @Override
    public void editPlato(Long id, Plato p) {
        
        //p es el plato con los datos nuevos
       //plat es el plato con los datos de la BD(viejos)
        Plato plat = this.findPlato(id);
        plat.setNombre(p.getNombre());
        plat.setPrecio(p.getPrecio());
        plat.setDescripcion(p.getDescripcion());
        plat.setListaIngredientes(p.getListaIngredientes());
        
        //Guardo en la BD los datos nuevos
        platoRepo.save(plat);
    }

    @Override
    public Plato findPlato(Long id) {
        return platoRepo.findById(id).orElse(null);
    }
    
}
