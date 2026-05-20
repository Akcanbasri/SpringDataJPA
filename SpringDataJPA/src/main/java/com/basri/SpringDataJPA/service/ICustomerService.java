package com.basri.SpringDataJPA.service;

import com.basri.SpringDataJPA.dto.request.CustomerSaveRequest;
import com.basri.SpringDataJPA.dto.response.CustomerResponse;

import java.util.List;

public interface ICustomerService {
    CustomerResponse save(CustomerSaveRequest request);
    List<CustomerResponse> findAll();
    CustomerResponse findById(Integer id);
}
