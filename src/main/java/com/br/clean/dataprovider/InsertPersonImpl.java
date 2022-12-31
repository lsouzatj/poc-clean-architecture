package com.br.clean.dataprovider;

import com.br.clean.core.dataprovider.InsertPerson;
import com.br.clean.core.domain.Person;
import com.br.clean.dataprovider.repository.PersonRepository;
import com.br.clean.dataprovider.repository.entity.PersonEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertPersonImpl implements InsertPerson {
    private final PersonRepository personRepository;
    @Override
    public Person insert(Person person) {
        PersonEntity personEntity = new PersonEntity();
        BeanUtils.copyProperties(person, personEntity);
        var personSaved = personRepository.save(personEntity);
        BeanUtils.copyProperties(personSaved, person);
        return person;
    }
}
