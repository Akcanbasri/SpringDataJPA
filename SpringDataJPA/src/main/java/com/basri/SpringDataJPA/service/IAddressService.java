package com.basri.SpringDataJPA.service;

import com.basri.SpringDataJPA.dto.request.AddressSaveRequest;
import com.basri.SpringDataJPA.dto.response.AddressResponse;
import java.util.List;

public interface IAddressService {
    List<AddressResponse> findAll();
    AddressResponse save(AddressSaveRequest addressSaveRequest);
}
