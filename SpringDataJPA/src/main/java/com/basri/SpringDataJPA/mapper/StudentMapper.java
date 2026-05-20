package com.basri.SpringDataJPA.mapper;

import com.basri.SpringDataJPA.dto.request.StudentSaveRequest;
import com.basri.SpringDataJPA.dto.response.StudentResponse;
import com.basri.SpringDataJPA.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {

    // StudentSaveRequest → Student (alan isimleri aynı olduğu için @Mapping
    // gerekmez; id DB tarafından üretildiği için yoksayılır)
    @Mapping(target = "id", ignore = true)
    Student toEntity(StudentSaveRequest request);

    // Student → StudentResponse
    StudentResponse toResponse(Student student);

    // List<Student> → List<StudentResponse> (MapStruct otomatik üretir)
    List<StudentResponse> toResponseList(List<Student> students);
}
