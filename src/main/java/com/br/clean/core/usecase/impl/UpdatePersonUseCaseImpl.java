package com.br.clean.core.usecase.impl;

import com.br.clean.core.dataprovider.UpdatePerson;
import com.br.clean.core.domain.Person;
import com.br.clean.core.usecase.UpdatePersonUseCase;

import java.util.Optional;

public class UpdatePersonUseCaseImpl implements UpdatePersonUseCase {
    private final UpdatePerson updatePerson;
    private final FindByIdPersonUserCaseImpl findByIdPersonUserCase;

    public UpdatePersonUseCaseImpl(UpdatePerson updatePerson, FindByIdPersonUserCaseImpl findByIdPersonUserCase) {
        this.updatePerson = updatePerson;
        this.findByIdPersonUserCase = findByIdPersonUserCase;
    }

    @Override
    public Optional<Person> update(Person person, Long id) {
        return findByIdPersonUserCase.findById(id).map((personOld)->{
            person.setId(personOld.getId());
            return updatePerson.update(person);
        }).orElse(Optional.empty());
    }
}
