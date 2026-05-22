package com.basri.SpringDataJPA.service.impl;

import com.basri.SpringDataJPA.dto.request.HomeSaveRequest;
import com.basri.SpringDataJPA.dto.response.HomeResponse;
import com.basri.SpringDataJPA.entity.Home;
import com.basri.SpringDataJPA.mapper.HomeMapper;
import com.basri.SpringDataJPA.repository.IHomeRepository;
import com.basri.SpringDataJPA.service.IHomeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeServiceImp implements IHomeService {
    private final IHomeRepository homeRepository;
    private final HomeMapper homeMapper;

    @Override
    public HomeResponse saveHome(HomeSaveRequest homeSaveRequest) {
        Home home = homeMapper.toEntity(homeSaveRequest);
        Home savedHome = homeRepository.save(home);
        return homeMapper.toResponse(savedHome);
    }
}
