package com.basri.SpringDataJPA.mapper;

import com.basri.SpringDataJPA.dto.request.AddressSaveRequest;
import com.basri.SpringDataJPA.dto.response.AddressResponse;
import com.basri.SpringDataJPA.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", ignore = true)
    Address toEntity(AddressSaveRequest addressSaveRequest);

    @Mapping(target = "customerId", source = "customer.id")
    AddressResponse toResponse(Address address);

    List<Address> toEntity(List<AddressSaveRequest> addressSaveRequests);

    List<AddressResponse> toResponse(List<Address> addresses);
}
