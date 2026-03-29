package com.basri.SpringDataJPA.service;

import com.basri.SpringDataJPA.dto.request.StudentSaveRequest;
import com.basri.SpringDataJPA.dto.response.StudentResponse;

import java.util.List;

public interface IStudentService {
    StudentResponse saveStudent(StudentSaveRequest request);

    List<StudentResponse> findAll();

    List<StudentResponse> findByNameAndSurname(String name, String surname);

    StudentResponse findById(int id);

    StudentResponse deleteById(int id);

    StudentResponse updateStudent(int id, StudentSaveRequest request);
}
