package com.basri.SpringDataJPA.controller;

import com.basri.SpringDataJPA.dto.request.EmployeeSaveRequest;
import com.basri.SpringDataJPA.dto.response.DepartmentResponse;
import com.basri.SpringDataJPA.dto.response.EmployeeResponse;
import com.basri.SpringDataJPA.service.IEmployeeService;
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
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
@Tag(name = "Employee Controller", description = "Operations related to Employee Management")
public class EmployeeController {
    private final IEmployeeService employeeService;

    @PostMapping()
    @Operation(summary = "Save a new Employee", description = "Adds a new Employee to the system and returns the saved Employee's details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee successfully saved"),
    })
    public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody EmployeeSaveRequest request){
        EmployeeResponse response = employeeService.saveEmployee(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping()
    @Operation(summary = "Find all departments" , description = "Find all departments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gets all Departments"),
    })
    public ResponseEntity<List<EmployeeResponse>> findAllDepartments() {
        List<EmployeeResponse> responses = employeeService.findAll();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

}
