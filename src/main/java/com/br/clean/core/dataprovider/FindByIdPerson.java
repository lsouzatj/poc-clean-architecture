package com.br.clean.core.dataprovider;

import com.br.clean.core.domain.Person;

import java.util.Optional;

public interface FindByIdPerson {
    Optional<Person> findById(Long id);
}
