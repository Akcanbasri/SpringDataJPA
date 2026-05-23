package com.basri.SpringDataJPA.service.impl;

import com.basri.SpringDataJPA.dto.request.HomeSaveRequest;
import com.basri.SpringDataJPA.dto.response.HomeResponse;
import com.basri.SpringDataJPA.entity.Home;
import com.basri.SpringDataJPA.entity.Room;
import com.basri.SpringDataJPA.exception.HomeNotFoundException;
import com.basri.SpringDataJPA.mapper.HomeMapper;
import com.basri.SpringDataJPA.repository.IHomeRepository;
import com.basri.SpringDataJPA.service.IHomeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HomeServiceImp implements IHomeService {
    private final IHomeRepository homeRepository;
    private final HomeMapper homeMapper;

    @Override
    public HomeResponse saveHome(HomeSaveRequest homeSaveRequest) {
        Home home = homeMapper.toEntity(homeSaveRequest);
        if (home.getRooms() != null) {
            home.getRooms().forEach(room -> room.setHome(home));
        }
        Home savedHome = homeRepository.save(home);
        return homeMapper.toResponse(savedHome);
    }

    @Override
    public List<HomeResponse> findAll() {
        List<Home> homes = homeRepository.findAll();
        return homeMapper.toResponseList(homes);
    }

    @Override
    public HomeResponse findById(int id) {

       Optional<Home> home =  homeRepository.findById(id);
        return home.map(homeMapper::toResponse).orElseThrow(() ->  new HomeNotFoundException("Home not found with given id : " + id));
    }

    @Override
    public HomeResponse updateHome(int id ,HomeSaveRequest homeSaveRequest) {
        Home savedHome = homeRepository.findById(id)
                .orElseThrow(() -> new HomeNotFoundException("Home not found with given id : " + id));

        // 1. Temel alanların güncellenmesi
        savedHome.setPrice(homeSaveRequest.getPrice());

        // 2. Odaların güncellenmesi (orphanRemoval = true sayesinde clear() çağrısı eski odaları db'den siler)
        savedHome.getRooms().clear();

        if (homeSaveRequest.getRooms() != null) {
            homeSaveRequest.getRooms().forEach(roomRequest -> {
                Room room = homeMapper.toEntity(roomRequest);
                room.setHome(savedHome); // Çift yönlü ilişki kuruluyor
                savedHome.getRooms().add(room);
            });
        }

        // 3. Değişikliklerin kaydedilmesi
        Home updatedHome = homeRepository.save(savedHome);
        return homeMapper.toResponse(updatedHome);
    }

    @Override
    public HomeResponse deleteById(int id) {
        Home home = homeRepository.findById(id)
                .orElseThrow(() -> new HomeNotFoundException("Home not found with given id : " + id));

        homeRepository.delete(home);
        return homeMapper.toResponse(home);
    }
}
