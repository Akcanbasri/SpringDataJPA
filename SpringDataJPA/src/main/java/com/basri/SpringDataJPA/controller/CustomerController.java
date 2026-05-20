package com.basri.SpringDataJPA.controller;

import com.basri.SpringDataJPA.dto.request.CustomerSaveRequest;
import com.basri.SpringDataJPA.dto.response.CustomerResponse;
import com.basri.SpringDataJPA.dto.response.StudentResponse;
import com.basri.SpringDataJPA.service.ICustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@Tag(name = "Customer Controller", description = "Operations related to Customer Management")
public class CustomerController {

    private final ICustomerService customerService;

    @PostMapping("/save")
    @Operation(summary = "Save a new Customer", description = "Adds a new customer to the system and returns the saved customer details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer successfully saved"),
    })
    public ResponseEntity<CustomerResponse> saveCustomer(@RequestBody CustomerSaveRequest request) {
       CustomerResponse response = customerService.save(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/find-all")
    @Operation(summary = "Get all customers", description = "Retrieves a list of all registered customers.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of customers successfully retrieved")
    })
    public ResponseEntity<List<CustomerResponse>> findAll() {
        List<CustomerResponse> customers = customerService.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    @GetMapping("/find-by-id")
    @Operation(summary = "Find customer by ID", description = "Retrieves a list of customers with the specified ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of customers successfully retrieved")
    })
    public ResponseEntity<CustomerResponse> findById(@RequestParam int id) {
        CustomerResponse response = customerService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
