package com.basri.SpringDataJPA.service.impl;

import com.basri.SpringDataJPA.dto.request.AddressSaveRequest;
import com.basri.SpringDataJPA.dto.response.AddressResponse;
import com.basri.SpringDataJPA.entity.Address;
import com.basri.SpringDataJPA.entity.Customer;
import com.basri.SpringDataJPA.exception.CustomerNotFoundException;
import com.basri.SpringDataJPA.mapper.AddressMapper;
import com.basri.SpringDataJPA.repository.IAddressRepository;
import com.basri.SpringDataJPA.repository.ICustomerRepository;
import com.basri.SpringDataJPA.service.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImp implements IAddressService {

    @Autowired
    private final IAddressRepository addressRepository;

    @Autowired
    private final ICustomerRepository customerRepository;

    @Autowired
    private final AddressMapper addressMapper;

    @Override
    public List<AddressResponse> findAll() {
        return addressMapper.toResponse(addressRepository.findAll());
    }

    @Override
    public AddressResponse save(AddressSaveRequest addressSaveRequest) {
        Customer customer = customerRepository.findById(addressSaveRequest.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not Found with Given Id" + addressSaveRequest.getCustomerId()));

        // 2. One-to-One Kuralı: Müşterinin zaten bir adresi var mı kontrol et
        if (customer.getAddress() != null) {
            throw new IllegalStateException("Customer with id " + addressSaveRequest.getCustomerId() + " already has an address!");
        }

        Address address = addressMapper.toEntity(addressSaveRequest);

        address.setCustomer(customer);
        customer.setAddress(address);

        Address savedAddress = addressRepository.save(address);
        return addressMapper.toResponse(savedAddress);
    }
}
