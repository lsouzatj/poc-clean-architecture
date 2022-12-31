package com.br.clean.core.dataprovider;

import com.br.clean.core.domain.Person;

import java.util.Optional;

public interface UpdatePerson {
    Optional<Person> update(Person person);
}
