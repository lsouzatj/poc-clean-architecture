package com.br.clean.entrypoint.controller.request;

import lombok.Data;
import lombok.Getter;

@Data public class PersonRequest {
    private String name;
    private String cep;
}
