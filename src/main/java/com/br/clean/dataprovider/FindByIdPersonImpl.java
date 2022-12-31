package com.br.clean.dataprovider;

import com.br.clean.core.dataprovider.FindByIdPerson;
import com.br.clean.core.domain.Person;
import com.br.clean.dataprovider.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindByIdPersonImpl implements FindByIdPerson {
    private final PersonRepository personRepository;

    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id).map(personEntity -> {
            Person person = new Person();
            BeanUtils.copyProperties(personEntity, person);
            return Optional.of(person);
        }).orElse(Optional.empty());
    }
}
