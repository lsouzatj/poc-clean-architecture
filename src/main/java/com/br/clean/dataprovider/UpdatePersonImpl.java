package com.br.clean.dataprovider;

import com.br.clean.core.dataprovider.UpdatePerson;
import com.br.clean.core.domain.Person;
import com.br.clean.dataprovider.repository.PersonRepository;
import com.br.clean.dataprovider.repository.entity.PersonEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UpdatePersonImpl implements UpdatePerson {
    private final PersonRepository personRepository;
    @Override
    public Optional<Person> update(Person person) {
        PersonEntity personEntity = new PersonEntity();
        BeanUtils.copyProperties(person, personEntity);
        var personUpdated = personRepository.save(personEntity);
        BeanUtils.copyProperties(personUpdated, person);
        return Optional.of(person);
    }
}
