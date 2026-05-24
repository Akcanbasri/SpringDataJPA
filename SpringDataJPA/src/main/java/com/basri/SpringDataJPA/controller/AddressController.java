package com.basri.SpringDataJPA.controller;

import com.basri.SpringDataJPA.dto.request.AddressSaveRequest;
import com.basri.SpringDataJPA.dto.response.AddressResponse;
import com.basri.SpringDataJPA.service.IAddressService;
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
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
@Tag(name = "Address Controller", description = "Operations related to Address Management")
public class AddressController {

    @Autowired
    private final IAddressService addressService;


    @GetMapping("/find-all")
    @Operation(summary = "find all all addresses", description = "gets all addresses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All addresses found")
    })
    public ResponseEntity<List<AddressResponse>> findAll(){
        List<AddressResponse> addresses = addressService.findAll();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }


    @PostMapping("/save")
    @Operation(summary = "Save address" , description = "saving address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "address saved")
    })
    public ResponseEntity<AddressResponse> save(@RequestBody AddressSaveRequest  addressSaveRequest){
        AddressResponse  addressResponse =  addressService.save(addressSaveRequest);
        return new ResponseEntity<>(addressResponse, HttpStatus.CREATED);
    }



}
