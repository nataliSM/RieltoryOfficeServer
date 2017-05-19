package ru.itis.inform.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Natalia on 13.05.17.
 */
@Configuration
public class ApplicationDependenciesConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
