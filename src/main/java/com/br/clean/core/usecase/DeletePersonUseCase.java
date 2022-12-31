package com.br.clean.core.usecase;

import com.br.clean.core.domain.Person;

import java.util.Optional;

public interface DeletePersonUseCase {
    Optional<Person> delete(Long id);
}
