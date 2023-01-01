package com.br.clean.core.usecase.impl;

import com.br.clean.core.dataprovider.FindAddressByZipCode;
import com.br.clean.core.dataprovider.FindByIdPerson;
import com.br.clean.core.domain.Person;
import com.br.clean.core.usecase.FindByIdPersonUseCase;

import java.util.Optional;

public class FindByIdPersonUserCaseImpl implements FindByIdPersonUseCase {
    private final FindByIdPerson findByIdPerson;
    private final FindAddressByZipCode findAddressByZipCode;

    public FindByIdPersonUserCaseImpl(FindByIdPerson findByIdPerson, FindAddressByZipCode findAddressByZipCode) {
        this.findByIdPerson = findByIdPerson;
        this.findAddressByZipCode = findAddressByZipCode;
    }

    @Override
    public Optional<Person> findById(Long id) {
        return findByIdPerson.findById(id).map(person -> {
            var address = findAddressByZipCode.FindByZipCode(person.getCep());
            person.setAddress(address);
            return person;
        });
    }
}
