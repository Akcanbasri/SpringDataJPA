package com.basri.SpringDataJPA.service;

import com.basri.SpringDataJPA.dto.request.HomeSaveRequest;
import com.basri.SpringDataJPA.dto.response.HomeResponse;

public interface IHomeService {
    public HomeResponse saveHome(HomeSaveRequest homeSaveRequest);
}
