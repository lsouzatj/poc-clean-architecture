package com.br.clean.config;

import com.br.clean.core.usecase.impl.DeletePersonUseCaseImpl;
import com.br.clean.core.usecase.impl.FindByIdPersonUserCaseImpl;
import com.br.clean.dataprovider.DeletePersonImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletePersonConfig {
    @Bean
    public DeletePersonUseCaseImpl deletePersonUseCase(FindByIdPersonUserCaseImpl findByIdPersonUserCase,
                                                       DeletePersonImpl deletePerson) {
        return new DeletePersonUseCaseImpl(deletePerson, findByIdPersonUserCase);
    }
}
