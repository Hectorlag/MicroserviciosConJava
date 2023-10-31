
package com.restaurant.plato.repository;

import com.restaurant.plato.model.Plato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iPlatoRepository extends JpaRepository<Plato, Long>{
    
    
    
}
