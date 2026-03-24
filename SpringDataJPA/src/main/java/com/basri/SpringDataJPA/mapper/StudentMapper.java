package com.basri.SpringDataJPA.mapper;

import com.basri.SpringDataJPA.dto.request.StudentSaveRequest;
import com.basri.SpringDataJPA.dto.response.StudentResponse;
import com.basri.SpringDataJPA.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    // DTO'yu Entity'ye çevirir
    public Student toEntity(StudentSaveRequest request) {
        if (request == null) {
            return null;
        }
        Student student = new Student();
        student.setName(request.getName());
        student.setSurname(request.getSurname());
        student.setBirthDate(request.getBirthDate());
        return student;
    }

    // Entity'yi DTO'ya çevirir
    public StudentResponse toResponse(Student entity) {
        if (entity == null) {
            return null;
        }
        return new StudentResponse(
                entity.getId(),
                entity.getName(),
                entity.getSurname(),
                entity.getBirthDate()
        );
    }
}
