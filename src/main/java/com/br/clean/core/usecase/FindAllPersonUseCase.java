package com.br.clean.core.usecase;

import com.br.clean.core.domain.Person;

import java.util.List;

public interface FindAllPersonUseCase {
    List<Person> findAll();
}
