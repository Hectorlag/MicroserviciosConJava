
package com.restaurant.ingredientes.repository;

import com.restaurant.ingredientes.model.Ingrediente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IingredienteRepository extends JpaRepository <Ingrediente, Long>{
    
    @Query("SELECT i FROM Ingrediente i WHERE :plato MEMBER OF i.platos")
    List<Ingrediente> findByNombre(String plato);
    
}
