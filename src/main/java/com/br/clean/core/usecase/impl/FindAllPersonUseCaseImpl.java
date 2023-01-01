package com.br.clean.core.usecase.impl;

import com.br.clean.core.dataprovider.FindAddressByZipCode;
import com.br.clean.core.dataprovider.FindAllPerson;
import com.br.clean.core.domain.Person;
import com.br.clean.core.usecase.FindAllPersonUseCase;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllPersonUseCaseImpl implements FindAllPersonUseCase {
    private final FindAllPerson findAllPerson;
    private final FindAddressByZipCode findAddressByZipCode;

    public FindAllPersonUseCaseImpl(FindAllPerson findAllPerson, FindAddressByZipCode findAddressByZipCode) {
        this.findAllPerson = findAllPerson;
        this.findAddressByZipCode = findAddressByZipCode;
    }

    @Override
    public List<Person> findAll() {
        return findAllPerson.findAll().stream()
                .map(person -> {
                    var address = findAddressByZipCode.FindByZipCode(person.getCep());
                    person.setAddress(address);
                    return person;
                }).collect(Collectors.toList());
    }
}
