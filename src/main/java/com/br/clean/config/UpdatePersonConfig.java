package com.br.clean.config;

import com.br.clean.core.usecase.impl.FindByIdPersonUserCaseImpl;
import com.br.clean.core.usecase.impl.UpdatePersonUseCaseImpl;
import com.br.clean.dataprovider.UpdatePersonImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdatePersonConfig {
    @Bean
    public UpdatePersonUseCaseImpl updatePersonUseCase(UpdatePersonImpl updatePerson,
                                                       FindByIdPersonUserCaseImpl findByIdPersonUserCase){
        return new UpdatePersonUseCaseImpl(updatePerson, findByIdPersonUserCase);
    }
}
