package com.basri.SpringDataJPA.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Room response DTO")
public class RoomResponse {
    private int id;

    private String name;
}
