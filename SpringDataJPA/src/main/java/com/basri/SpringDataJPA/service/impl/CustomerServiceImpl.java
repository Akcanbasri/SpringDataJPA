package com.basri.SpringDataJPA.service.impl;

import com.basri.SpringDataJPA.dto.request.CustomerSaveRequest;
import com.basri.SpringDataJPA.dto.response.CustomerResponse;
import com.basri.SpringDataJPA.entity.Address;
import com.basri.SpringDataJPA.entity.Customer;
import com.basri.SpringDataJPA.exception.CustomerNotFoundException;
import com.basri.SpringDataJPA.mapper.CustomerMapper;
import com.basri.SpringDataJPA.repository.ICustomerRepository;
import com.basri.SpringDataJPA.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
    private final ICustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse save(CustomerSaveRequest customerSaveRequest) {
        // 1. DTO'yu Entity'ye dönüştür
        Customer customer = customerMapper.toEntity(customerSaveRequest);
        
        // 2. Address var ise, geri referansı ayarla (OneToOne ilişki)
        Address address = customer.getAddress();
        if (address != null) {
            address.setCustomer(customer);
        }
        
        // 3. Customer'ı database'e kaydet (cascade.ALL sayesinde Address de kaydedilir)
        Customer savedCustomer = customerRepository.save(customer);
        
        // 4. Entity'yi DTO'ya dönüştürüp döndür
        return customerMapper.toResponse(savedCustomer);
    }

    @Override
    public List<CustomerResponse> findAll() {
        return customerMapper.toResponse(customerRepository.findAll());
    }

    @Override
    public CustomerResponse findById(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
        return customerMapper.toResponse(customer);
    }

}
