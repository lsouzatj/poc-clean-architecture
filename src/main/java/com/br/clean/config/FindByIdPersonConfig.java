package com.br.clean.config;

import com.br.clean.core.usecase.impl.FindByIdPersonUserCaseImpl;
import com.br.clean.dataprovider.FindAddressByZipCodeImpl;
import com.br.clean.dataprovider.FindByIdPersonImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindByIdPersonConfig {
    @Bean
    public FindByIdPersonUserCaseImpl findByIdPersonUserCase(FindByIdPersonImpl findByIdPerson,
                                                             FindAddressByZipCodeImpl findAddressByZipCode){
        return new FindByIdPersonUserCaseImpl(findByIdPerson, findAddressByZipCode);
    }
}
