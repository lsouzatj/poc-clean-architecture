package com.br.clean.core.usecase.impl;

import com.br.clean.core.dataprovider.DeletePerson;
import com.br.clean.core.domain.Person;
import com.br.clean.core.usecase.DeletePersonUseCase;
import org.springframework.beans.BeanUtils;

import java.util.Optional;

public class DeletePersonUseCaseImpl implements DeletePersonUseCase {
    private final DeletePerson deletePerson;
    private final FindByIdPersonUserCaseImpl findByIdPersonUserCase;

    public DeletePersonUseCaseImpl(DeletePerson deletePerson, FindByIdPersonUserCaseImpl findByIdPersonUserCase) {
        this.deletePerson = deletePerson;
        this.findByIdPersonUserCase = findByIdPersonUserCase;
    }

    @Override
    public Optional<Person> delete(Long id) {
        return findByIdPersonUserCase.findById(id).map(personEntity -> {
            Person person = new Person();
            BeanUtils.copyProperties(personEntity, person);
            deletePerson.delete(id);
            return Optional.of(person);
        }).orElse(Optional.empty());
    }
}
