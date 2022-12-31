package com.br.clean.entrypoint.controller.response;

import com.br.clean.core.domain.Address;
import lombok.Setter;

@Setter
public class ResponsePerson {
    private Long id;
    private String name;
    private String cep;
    private Address address;
}
