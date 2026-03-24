package com.basri.SpringDataJPA.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentSaveRequest {
    private String name;
    private String surname;
    private LocalDate birthDate;
}
