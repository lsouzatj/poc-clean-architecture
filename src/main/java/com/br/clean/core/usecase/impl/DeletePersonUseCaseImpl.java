package com.br.clean.core.usecase.impl;

import com.br.clean.core.dataprovider.DeletePerson;
import com.br.clean.core.dataprovider.SystemNotification;
import com.br.clean.core.domain.Person;
import com.br.clean.core.usecase.DeletePersonUseCase;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;

public class DeletePersonUseCaseImpl implements DeletePersonUseCase {
    private final DeletePerson deletePerson;
    private final FindByIdPersonUserCaseImpl findByIdPersonUserCase;
    private final SystemNotification systemNotification;
    @Value("${message.client.delete}")
    private String messageClientDelete;

    public DeletePersonUseCaseImpl(DeletePerson deletePerson, FindByIdPersonUserCaseImpl findByIdPersonUserCase, SystemNotification systemNotification) {
        this.deletePerson = deletePerson;
        this.findByIdPersonUserCase = findByIdPersonUserCase;
        this.systemNotification = systemNotification;
    }

    @Override
    public Optional<Person> delete(Long id) {
        return findByIdPersonUserCase.findById(id).map(personEntity -> {
            Person person = new Person();
            BeanUtils.copyProperties(personEntity, person);
            deletePerson.delete(id);
            systemNotification.sendNotification(messageClientDelete);
            return Optional.of(person);
        }).orElse(Optional.empty());
    }
}
