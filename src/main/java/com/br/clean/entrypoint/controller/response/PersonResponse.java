package com.br.clean.entrypoint.controller.response;

import com.br.clean.core.domain.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Setter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonResponse {
    private Long id;
    private String name;
    private String cep;
    private Address address;
}
