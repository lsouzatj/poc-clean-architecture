package com.br.clean.dataprovider;

import com.br.clean.core.dataprovider.FindAddressByZipCode;
import com.br.clean.core.domain.Address;
import com.br.clean.dataprovider.client.FindAddressByZipCodeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAddressByZipCodeImpl implements FindAddressByZipCode {

    private final FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Override
    public Address FindByZipCode(String cep) {
        var addressResponse = findAddressByZipCodeClient.findByZipCodeCorreios(cep);
        Address address = new Address();
        BeanUtils.copyProperties(addressResponse, address);
        return address;
    }
}
