package com.br.clean.entrypoint.controller;

import com.br.clean.core.domain.Person;
import com.br.clean.core.usecase.*;
import com.br.clean.entrypoint.controller.request.PersonRequest;
import com.br.clean.entrypoint.controller.response.PersonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/person")
public class PersonController {
    private final InsertPersonUseCase insertPersonUseCase;
    private final FindAllPersonUseCase findAllPersonUseCase;
    private final FindByIdPersonUseCase findByIdPersonUseCase;
    private final UpdatePersonUseCase updatePersonUseCase;
    private final DeletePersonUseCase deletePersonUseCase;

    @PostMapping("/insert")
    public ResponseEntity<PersonResponse> insertPerson(@RequestBody PersonRequest personRequest){
        log.info("Process initial of insert.");
        Person person = new Person();
        BeanUtils.copyProperties(personRequest, person);
        return Optional.of(insertPersonUseCase.insert(person)).map(personSaved ->{
            PersonResponse personResponse = new PersonResponse();
            BeanUtils.copyProperties(personSaved, personResponse);
            log.info("Person saved successfuly.");
            return ResponseEntity.status(HttpStatus.CREATED).body(personResponse);
        }).orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<PersonResponse>> findAllPerson(){
        log.info("Process initial of findAll.");
        return (ResponseEntity<List<PersonResponse>>) Optional.of(findAllPersonUseCase.findAll())
                .map(listPerson ->{
                    if (listPerson.isEmpty()) {
                        log.info("Listing executed successfuly. Registry inexists.");
                        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                    }
                    List<PersonResponse> listPersonResponse = listPerson.stream()
                            .map(person -> {
                                PersonResponse personResponse = new PersonResponse();
                                BeanUtils.copyProperties(person, personResponse);
                                return personResponse;
                            }).collect(Collectors.toList());
                    log.info("Listing executed successfuly.");
                    return ResponseEntity.status(HttpStatus.OK).body(listPersonResponse);
                }).orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PersonResponse> findByIdPerson(@PathVariable Long id){
        log.info("Process initial of find.");
        return findByIdPersonUseCase.findById(id).map(person -> {
            PersonResponse personResponse = new PersonResponse();
            BeanUtils.copyProperties(person, personResponse);
            log.info("Find executed successfuly.");
            return ResponseEntity.status(HttpStatus.OK).body(personResponse);
        }).orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PersonResponse> updatePerson(@RequestBody PersonRequest personRequest, @PathVariable Long id){
        log.info("Process initial of update.");
        Person person = new Person();
        BeanUtils.copyProperties(personRequest, person);
        return updatePersonUseCase.update(person, id).map(personUpdated -> {
            PersonResponse personResponse = new PersonResponse();
            BeanUtils.copyProperties(personUpdated, personResponse);
            log.info("Update executed successfuly.");
            return ResponseEntity.status(HttpStatus.OK).body(personResponse);
        }).orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PersonResponse> deletePerson(@PathVariable Long id){
        log.info("Process initial of delete.");
        return deletePersonUseCase.delete(id).map(personDeleted -> {
            PersonResponse personResponse = new PersonResponse();
            BeanUtils.copyProperties(personDeleted, personResponse);
            log.info("Delete executed successfuly.");
            return ResponseEntity.status(HttpStatus.OK).body(personResponse);
        }).orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }
}
