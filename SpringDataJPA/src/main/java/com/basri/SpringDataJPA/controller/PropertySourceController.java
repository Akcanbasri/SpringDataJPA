package com.basri.SpringDataJPA.controller;

import com.basri.SpringDataJPA.config.DataSourceDTO;
import com.basri.SpringDataJPA.config.GlobalPorperties;
import com.basri.SpringDataJPA.config.GlobalPropertiesSecond;
import com.basri.SpringDataJPA.config.Server;
import com.basri.SpringDataJPA.dto.response.AddressResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/api/property")
@RequiredArgsConstructor
@Tag(name = "Property Source Controller", description = "Operations related to Property Source Management")
public class PropertySourceController {

    private final GlobalPorperties globalPorperties;

    private final GlobalPropertiesSecond  GlobalPropertiesSecond;

    @GetMapping("/getpropertysource")
    @Operation(summary = "find Property Source", description = "gets Property Source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Property Sources found")
    })
    public ResponseEntity<DataSourceDTO> getDataSource() {
        DataSourceDTO dto = new DataSourceDTO();
        dto.setPassword(globalPorperties.getPassword());
        dto.setUsername(globalPorperties.getUsername());
        dto.setUrl(globalPorperties.getUrl());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/getservers")
    @Operation(summary = "find Servers", description = "gets Servers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Servers found")
    })
    public ResponseEntity<List<Server>> getServers() {
      List<Server> servers = new ArrayList<>();
      servers = GlobalPropertiesSecond.getServers();
      return new ResponseEntity<>(servers, HttpStatus.OK);

    }

}
