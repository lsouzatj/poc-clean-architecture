package com.br.clean.entrypoint.controller.response;

import com.br.clean.core.domain.Address;
import lombok.Data;
import lombok.Setter;

@Data
public class PersonResponse {
    private Long id;
    private String name;
    private String cep;
    private Address address;
}
