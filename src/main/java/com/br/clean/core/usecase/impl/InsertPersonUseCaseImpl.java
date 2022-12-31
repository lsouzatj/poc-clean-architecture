package com.br.clean.core.usecase.impl;

import com.br.clean.core.dataprovider.InsertPerson;
import com.br.clean.core.domain.Person;
import com.br.clean.core.usecase.InsertPersonUseCase;

public class InsertPersonUseCaseImpl implements InsertPersonUseCase {
    private final InsertPerson insertPerson;

    public InsertPersonUseCaseImpl(InsertPerson insertPerson) {
        this.insertPerson = insertPerson;
    }

    @Override
    public Person insert(Person person) {
        var personSaved =insertPerson.insert(person);
        return personSaved;
    }
}
