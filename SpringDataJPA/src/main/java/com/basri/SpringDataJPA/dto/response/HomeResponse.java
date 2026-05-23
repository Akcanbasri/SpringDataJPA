package com.basri.SpringDataJPA.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Home response DTO")
public class HomeResponse {
    private int id;

    private BigDecimal price;

    private List<RoomResponse> rooms =  new ArrayList<>();
}
