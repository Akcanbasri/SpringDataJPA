package com.basri.SpringDataJPA.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Employee response")
public class EmployeeResponse {
    private int id;

    private String firstName;

    private String lastName;

    private DepartmentResponse department;
}
