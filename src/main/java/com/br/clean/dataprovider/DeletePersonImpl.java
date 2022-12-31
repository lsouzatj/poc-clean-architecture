package com.br.clean.dataprovider;

import com.br.clean.core.dataprovider.DeletePerson;
import com.br.clean.core.domain.Person;
import com.br.clean.dataprovider.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletePersonImpl implements DeletePerson {
    private final PersonRepository personRepository;
    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }
}
