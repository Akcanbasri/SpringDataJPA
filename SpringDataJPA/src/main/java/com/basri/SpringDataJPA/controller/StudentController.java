package com.basri.SpringDataJPA.controller;

import com.basri.SpringDataJPA.dto.request.StudentSaveRequest;
import com.basri.SpringDataJPA.dto.response.StudentResponse;
import com.basri.SpringDataJPA.service.IStudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@Tag(name = "Student Controller", description = "Operations related to Student Management")
public class StudentController {

    private final IStudentService studentService;

    @PostMapping("/save")
    @Operation(summary = "Save a new student", description = "Adds a new student to the system and returns the saved student details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Student successfully saved"),
            @ApiResponse(responseCode = "400", description = "Invalid student age or data provided")
    })
    public ResponseEntity<StudentResponse> saveStudent(@RequestBody StudentSaveRequest request) {
        StudentResponse response = studentService.saveStudent(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
