package com.br.clean.config;

import com.br.clean.core.usecase.impl.InsertPersonUseCaseImpl;
import com.br.clean.dataprovider.InsertPersonImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertPersonConfig {
    @Bean
    public InsertPersonUseCaseImpl insertPersonUseCase(InsertPersonImpl insertPerson){
        return new InsertPersonUseCaseImpl(insertPerson);
    }
}
