package com.basri.SpringDataJPA.controller;

import com.basri.SpringDataJPA.dto.request.StudentSaveRequest;
import com.basri.SpringDataJPA.dto.response.StudentResponse;
import com.basri.SpringDataJPA.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<StudentResponse> saveStudent(@RequestBody StudentSaveRequest request) {
        StudentResponse response = studentService.saveStudent(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
