package com.basri.SpringDataJPA.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Course Save Request DTO")
public class CourseSaveRequest {

    @Schema(description = "Name of the course", example = "Spring Boot")
    @NotBlank(message = "Course name can not be blank!")
    @Size(min = 2, max = 50, message = "Course name must be between 2 and 50 characters")
    private String courseName;
}