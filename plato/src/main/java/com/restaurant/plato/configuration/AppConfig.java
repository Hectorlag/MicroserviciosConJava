
package com.restaurant.plato.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//Establecemos que es una clase de configuración
@Configuration
public class AppConfig {
    
     @Bean("apiIngredientes")
    public RestTemplate registrarRestTemplate(){
       return new RestTemplate();
    }
    
}
