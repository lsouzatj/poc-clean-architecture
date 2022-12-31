package com.br.clean.config;

import com.br.clean.core.usecase.impl.FindAllPersonUseCaseImpl;
import com.br.clean.dataprovider.FindAllPersonImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindAllPersonConfig {
    @Bean
    public FindAllPersonUseCaseImpl findAllPersonUseCase(FindAllPersonImpl findAllPerson){
        return new FindAllPersonUseCaseImpl(findAllPerson);
    }
}
