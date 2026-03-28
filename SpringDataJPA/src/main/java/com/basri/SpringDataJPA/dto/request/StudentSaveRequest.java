package com.basri.SpringDataJPA.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data Transfer Object for saving a new student")
public class StudentSaveRequest {
    @Schema(description = "First name of the student", example = "John")
    private String name;

    @Schema(description = "Last name of the student", example = "Doe")
    private String surname;

    @Schema(description = "Birth date of the student", example = "2000-01-01")
    private LocalDate birthDate;
}

    

    