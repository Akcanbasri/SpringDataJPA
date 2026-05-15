package com.basri.SpringDataJPA.mapper;

import com.basri.SpringDataJPA.dto.request.AddressSaveRequest;
import com.basri.SpringDataJPA.dto.request.CustomerSaveRequest;
import com.basri.SpringDataJPA.dto.response.AddressResponse;
import com.basri.SpringDataJPA.dto.response.CustomerResponse;
import com.basri.SpringDataJPA.entity.Address;
import com.basri.SpringDataJPA.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

   Customer toEntity(CustomerSaveRequest customerSaveRequest);

   Address toEntity(AddressSaveRequest addressSaveRequest);

   CustomerResponse toResponse(Customer customer);

   List<CustomerResponse> toResponse(List<Customer> customers);

   AddressResponse toResponse(Address address);
}