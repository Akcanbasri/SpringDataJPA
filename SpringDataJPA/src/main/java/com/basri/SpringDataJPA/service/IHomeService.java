package com.basri.SpringDataJPA.service;

import com.basri.SpringDataJPA.dto.request.HomeSaveRequest;
import com.basri.SpringDataJPA.dto.response.HomeResponse;
import com.basri.SpringDataJPA.entity.Home;

import java.util.List;

public interface IHomeService {
    public HomeResponse saveHome(HomeSaveRequest homeSaveRequest);
    public List<HomeResponse> findAll();
    public HomeResponse findById(int id);
    public HomeResponse updateHome(int id,HomeSaveRequest homeSaveRequest);
    public HomeResponse deleteById(int id);
}
