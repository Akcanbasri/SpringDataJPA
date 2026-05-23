package com.basri.SpringDataJPA.mapper;

import com.basri.SpringDataJPA.dto.request.HomeSaveRequest;
import com.basri.SpringDataJPA.dto.request.RoomSaveRequest;
import com.basri.SpringDataJPA.dto.response.HomeResponse;
import com.basri.SpringDataJPA.dto.response.RoomResponse;
import com.basri.SpringDataJPA.entity.Home;
import com.basri.SpringDataJPA.entity.Room;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HomeMapper {

    @Mapping(target = "id", ignore = true)
    Home toEntity(HomeSaveRequest homeSaveRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "home", ignore = true)
    Room toEntity(RoomSaveRequest roomSaveRequest);

    HomeResponse toResponse(Home home);

    RoomResponse toResponse(Room room);

    List<HomeResponse> toResponseList(List<Home> homes);
}
