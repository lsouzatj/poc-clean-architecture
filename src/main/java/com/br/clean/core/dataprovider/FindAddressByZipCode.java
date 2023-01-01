package com.br.clean.core.dataprovider;

import com.br.clean.core.domain.Address;

public interface FindAddressByZipCode {
    Address FindByZipCode(String cep);
}
