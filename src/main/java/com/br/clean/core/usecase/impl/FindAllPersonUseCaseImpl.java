package com.br.clean.core.usecase.impl;

import com.br.clean.core.dataprovider.FindAllPerson;
import com.br.clean.core.domain.Person;
import com.br.clean.core.usecase.FindAllPersonUseCase;

import java.util.List;

public class FindAllPersonUseCaseImpl implements FindAllPersonUseCase {
    private final FindAllPerson findAllPerson;

    public FindAllPersonUseCaseImpl(FindAllPerson findAllPerson) {
        this.findAllPerson = findAllPerson;
    }

    @Override
    public List<Person> findAll() {
        return findAllPerson.findAll();
    }
}
