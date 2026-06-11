package com.basri.SpringDataJPA.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "Employee save request")
public class EmployeeSaveRequest {
    private String firstName;

    private String lastName;

    private Integer departmentId;
}
