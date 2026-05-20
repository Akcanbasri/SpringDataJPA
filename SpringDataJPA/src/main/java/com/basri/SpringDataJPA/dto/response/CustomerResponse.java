package com.basri.SpringDataJPA.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private int id;
    private String firstName;
    private String lastName;
    private AddressResponse address;
}
