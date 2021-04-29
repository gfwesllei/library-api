package br.com.gfwesllei.library.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author weslleiferreira
 * @project library
 */
@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
