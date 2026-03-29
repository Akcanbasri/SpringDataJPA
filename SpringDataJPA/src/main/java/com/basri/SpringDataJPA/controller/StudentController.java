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

import java.util.List;

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

    @GetMapping("/find-all")
    @Operation(summary = "Get all students", description = "Retrieves a list of all registered students.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of students successfully retrieved")
    })
    public ResponseEntity<List<StudentResponse>> findAll() {
        List<StudentResponse> students = studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/find-by-name-and-surname")
    @Operation(summary = "Find student by name and surname", description = "Retrieves a list of students with the specified name and surname.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of students successfully retrieved")
    })
    public ResponseEntity<List<StudentResponse>> findByNameAndSurname(@RequestParam(required = false) String name,
            @RequestParam(required = false) String surname) {
        List<StudentResponse> response = studentService.findByNameAndSurname(name, surname);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/find-by-id")
    @Operation(summary = "Find student by ID", description = "Retrieves a list of students with the specified ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of students successfully retrieved")
    })
    public ResponseEntity<StudentResponse> findById(@RequestParam int id) {
        StudentResponse response = studentService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete-by-id")
    @Operation(summary = "Delete student by ID", description = "Deletes a student with the specified ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student successfully deleted")
    })
    public ResponseEntity<StudentResponse> deleteById(@RequestParam int id) {
        StudentResponse response = studentService.deleteById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update-student")
    @Operation(summary = "Update student by ID", description = "Updates a student with the specified ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student successfully updated")
    })
    public ResponseEntity<StudentResponse> updateStudent(@RequestParam int id,
            @RequestBody StudentSaveRequest request) {
        StudentResponse response = studentService.updateStudent(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
