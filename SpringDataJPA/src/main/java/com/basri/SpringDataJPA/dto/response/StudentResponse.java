package com.basri.SpringDataJPA.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response object representing student details")
public class StudentResponse {
    @Schema(description = "Unique ID of the student", example = "1")
    private int id;
    
    @Schema(description = "First name of the student", example = "John")
    private String name;
    
    @Schema(description = "Last name of the student", example = "Doe")
    private String surname;
    
    @Schema(description = "Birth date of the student", example = "2000-01-01")
    private LocalDate birthDate;
}
