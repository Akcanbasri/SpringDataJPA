package com.basri.SpringDataJPA.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "Data Transfer Object for saving a new customer's address")
public class AddressSaveRequest {
    private String description;
}
