package com.br.clean.core.usecase;

import com.br.clean.core.domain.Person;

import java.util.Optional;

public interface FindByIdPersonUseCase {
    Optional<Person> findById(Long id);
}
