package com.basri.SpringDataJPA.controller;

import com.basri.SpringDataJPA.dto.request.CustomerSaveRequest;
import com.basri.SpringDataJPA.dto.request.HomeSaveRequest;
import com.basri.SpringDataJPA.dto.response.CustomerResponse;
import com.basri.SpringDataJPA.dto.response.HomeResponse;
import com.basri.SpringDataJPA.service.IHomeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/homes")
@RequiredArgsConstructor
@Tag(name = "Home Controller", description = "Operations related to Home Management")
public class HomeController {

    private final IHomeService homeService;

    @PostMapping("/save")
    @Operation(summary = "Save a new Home", description = "Adds a new Home to the system and returns the saved Home's details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer successfully saved"),
    })
    public ResponseEntity<HomeResponse> saveHome(@RequestBody HomeSaveRequest request) {
       HomeResponse  response = homeService.saveHome(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
