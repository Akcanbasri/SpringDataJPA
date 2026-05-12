package com.basri.SpringDataJPA.mapper;

import com.basri.SpringDataJPA.dto.request.StudentSaveRequest;
import com.basri.SpringDataJPA.dto.response.StudentResponse;
import com.basri.SpringDataJPA.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    // DTO'yu Entity'ye çevirir
    Student toEntity(StudentSaveRequest request);

    // Entity'yi DTO'ya çevirir
    StudentResponse toResponse(Student student);

    // Entity listesini Response listesine çevirir
    List<StudentResponse> toResponseList(List<Student> entities);
}
