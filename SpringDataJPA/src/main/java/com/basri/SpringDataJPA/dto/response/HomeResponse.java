package com.basri.SpringDataJPA.dto.response;

import com.basri.SpringDataJPA.entity.Room;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
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

    private List<Room> rooms =  new ArrayList<>();
}
