package com.br.clean.dataprovider;

import com.br.clean.core.dataprovider.FindAllPerson;
import com.br.clean.core.domain.Person;
import com.br.clean.dataprovider.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FindAllPersonImpl implements FindAllPerson {
    private final PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll().stream()
                .map(personEntitty ->{
                    Person person = new Person();
                    BeanUtils.copyProperties(personEntitty, person);
                    return person;
                }).collect(Collectors.toList());
    }
}
