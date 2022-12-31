package com.br.clean.entrypoint.controller;

import com.br.clean.core.domain.Person;
import com.br.clean.core.usecase.InsertPersonUseCase;
import com.br.clean.entrypoint.controller.response.ResponsePerson;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/person")
public class PersonController {
    private final InsertPersonUseCase insertPersonUseCase;

    @PostMapping("/insert")
    public ResponseEntity<ResponsePerson> insertPerson(@RequestBody Person person){
        log.info("Process initial of insert.");
        return Optional.of(insertPersonUseCase.insert(person)).map(personSaved ->{
            ResponsePerson responsePerson = new ResponsePerson();
            BeanUtils.copyProperties(personSaved, responsePerson);
            log.info("Person saved successfuly.");
            return ResponseEntity.status(HttpStatus.CREATED).body(responsePerson);
        }).orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }
}
