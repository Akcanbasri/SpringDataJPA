package com.basri.SpringDataJPA.dto.request;

import com.basri.SpringDataJPA.entity.Room;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Schema(description = "Data Transfer Object for saving a new home")
public class HomeSaveRequest {

    private BigDecimal price;

    private List<RoomSaveRequest> rooms =  new ArrayList<>();
}
