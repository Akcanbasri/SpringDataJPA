package com.basri.SpringDataJPA.mapper;

import com.basri.SpringDataJPA.dto.request.HomeSaveRequest;
import com.basri.SpringDataJPA.dto.response.HomeResponse;
import com.basri.SpringDataJPA.dto.response.RoomResponse;
import com.basri.SpringDataJPA.entity.Home;
import com.basri.SpringDataJPA.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HomeMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rooms", ignore = true)
    Home toEntity(HomeSaveRequest homeSaveRequest);

    HomeResponse toResponse(Home home);

    RoomResponse toResponse(Room room);

    List<HomeResponse> toResponseList(List<Home> homes);


}
