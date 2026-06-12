package com.basri.SpringDataJPA.controller;

import com.basri.SpringDataJPA.dto.request.DepartmentSaveRequest;
import com.basri.SpringDataJPA.dto.response.DepartmentResponse;
import com.basri.SpringDataJPA.dto.response.HomeResponse;
import com.basri.SpringDataJPA.entity.Department;
import com.basri.SpringDataJPA.service.IDepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
@Tag(name = "Department Controller", description = "Operations related to Department Management")
public class DepartmentController {

    @Autowired
    private final IDepartmentService departmentService;

    @PostMapping()
    @Operation(summary = "Save a new Department", description = "Adds a new Department to the system and returns the saved Department's details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Department successfully saved"),
    })
    public ResponseEntity<DepartmentResponse> saveDepartment(@RequestBody DepartmentSaveRequest request) {
        DepartmentResponse response = departmentService.saveDepartment(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping()
    @Operation(summary = "Find all departments" , description = "Find all departments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gets all Departments"),
    })
    public ResponseEntity<List<DepartmentResponse>> findAllDepartments() {
        List<DepartmentResponse> responses = departmentService.findAll();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
