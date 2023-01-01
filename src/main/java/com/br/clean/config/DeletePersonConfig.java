package com.br.clean.config;

import com.br.clean.core.usecase.impl.DeletePersonUseCaseImpl;
import com.br.clean.core.usecase.impl.FindByIdPersonUserCaseImpl;
import com.br.clean.dataprovider.DeletePersonImpl;
import com.br.clean.dataprovider.SystemNotificationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletePersonConfig {
    @Bean
    public DeletePersonUseCaseImpl deletePersonUseCase(FindByIdPersonUserCaseImpl findByIdPersonUserCase,
                                                       DeletePersonImpl deletePerson,
                                                       SystemNotificationImpl systemNotification) {
        return new DeletePersonUseCaseImpl(deletePerson, findByIdPersonUserCase, systemNotification);
    }
}
