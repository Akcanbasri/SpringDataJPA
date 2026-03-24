package com.basri.SpringDataJPA.service;

import com.basri.SpringDataJPA.dto.request.StudentSaveRequest;
import com.basri.SpringDataJPA.dto.response.StudentResponse;

public interface IStudentService {
    StudentResponse saveStudent(StudentSaveRequest request);
}
