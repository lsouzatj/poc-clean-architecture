package com.br.clean.core.usecase.impl;

import com.br.clean.core.dataprovider.SystemNotification;
import com.br.clean.core.dataprovider.UpdatePerson;
import com.br.clean.core.domain.Person;
import com.br.clean.core.usecase.UpdatePersonUseCase;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;

public class UpdatePersonUseCaseImpl implements UpdatePersonUseCase {
    private final UpdatePerson updatePerson;
    private final FindByIdPersonUserCaseImpl findByIdPersonUserCase;
    private final SystemNotification systemNotification;
    @Value("${message.client.update}")
    private String messageClienteUpdate;

    public UpdatePersonUseCaseImpl(UpdatePerson updatePerson, FindByIdPersonUserCaseImpl findByIdPersonUserCase, SystemNotification systemNotification) {
        this.updatePerson = updatePerson;
        this.findByIdPersonUserCase = findByIdPersonUserCase;
        this.systemNotification = systemNotification;
    }

    @Override
    public Optional<Person> update(Person person, Long id) {
        return findByIdPersonUserCase.findById(id).map((personOld)->{
            person.setId(personOld.getId());
            systemNotification.sendNotification(messageClienteUpdate);
            return updatePerson.update(person);
        }).orElse(Optional.empty());
    }
}
