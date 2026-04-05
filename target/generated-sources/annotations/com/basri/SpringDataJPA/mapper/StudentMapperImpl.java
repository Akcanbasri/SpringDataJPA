package com.basri.SpringDataJPA.mapper;

import com.basri.SpringDataJPA.dto.request.StudentSaveRequest;
import com.basri.SpringDataJPA.dto.response.StudentResponse;
import com.basri.SpringDataJPA.entity.Student;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-05T09:15:07+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Amazon.com Inc.)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student toEntity(StudentSaveRequest request) {
        if ( request == null ) {
            return null;
        }

        Student student = new Student();

        student.setName( request.getName() );
        student.setSurname( request.getSurname() );
        student.setBirthDate( request.getBirthDate() );

        return student;
    }

    @Override
    public StudentResponse toResponse(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentResponse studentResponse = new StudentResponse();

        studentResponse.setId( student.getId() );
        studentResponse.setName( student.getName() );
        studentResponse.setSurname( student.getSurname() );
        studentResponse.setBirthDate( student.getBirthDate() );

        return studentResponse;
    }

    @Override
    public List<StudentResponse> toResponseList(List<Student> students) {
        if ( students == null ) {
            return null;
        }

        List<StudentResponse> list = new ArrayList<StudentResponse>( students.size() );
        for ( Student student : students ) {
            list.add( toResponse( student ) );
        }

        return list;
    }
}
