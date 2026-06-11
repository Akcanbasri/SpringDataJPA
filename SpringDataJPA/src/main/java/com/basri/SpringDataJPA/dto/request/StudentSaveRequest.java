package com.basri.SpringDataJPA.dto.request;

import com.basri.SpringDataJPA.entity.Course;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data Transfer Object for saving a new student")
public class StudentSaveRequest {
    @Schema(description = "First name of the student", example = "John")
    @NotEmpty(message = "Name can not be empty!")
    @Size(min = 2 , max = 20, message = "Name's length must be between 2 and 20")
    private String name;

    @Schema(description = "Last name of the student", example = "Doe")
    @Size(min = 2 , max = 20, message = "Surname's length must be between 2 and 20")
    private String surname;

    @Schema(description = "Birth date of the student", example = "2000-01-01")
    @NotNull
    private LocalDate birthDate;

    @Schema(description = "TC identity Number", example = "11111111111")
    @NotEmpty
    @Size(min = 11, max = 11)
    private  String tckNo;

    @Schema(description = "Course ids of the student", example = "[1, 2]")
    @NotEmpty(message = "Course ids can not be empty!")
    private List<Integer> courseIds;
}
