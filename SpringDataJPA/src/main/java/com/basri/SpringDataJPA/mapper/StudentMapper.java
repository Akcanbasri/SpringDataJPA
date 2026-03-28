package com.basri.SpringDataJPA.mapper;

import com.basri.SpringDataJPA.dto.request.StudentSaveRequest;
import com.basri.SpringDataJPA.dto.response.StudentResponse;
import com.basri.SpringDataJPA.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    // Entity listesini Response listesine çevirir
    public List<StudentResponse> toResponseList(List<Student> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
