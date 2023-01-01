package com.br.clean.dataprovider.client.responseClient;

import lombok.Data;

@Data
public class AddressResponse {
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
}
