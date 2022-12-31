package com.br.clean.core.usecase.impl;

import com.br.clean.core.dataprovider.FindByIdPerson;
import com.br.clean.core.domain.Person;
import com.br.clean.core.usecase.FindByIdPersonUseCase;

import java.util.Optional;

public class FindByIdPersonUserCaseImpl implements FindByIdPersonUseCase {
    private final FindByIdPerson findByIdPerson;

    public FindByIdPersonUserCaseImpl(FindByIdPerson findByIdPerson) {
        this.findByIdPerson = findByIdPerson;
    }

    @Override
    public Optional<Person> findById(Long id) {
        return findByIdPerson.findById(id);
    }
}
