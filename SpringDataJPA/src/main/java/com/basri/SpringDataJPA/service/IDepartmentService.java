package com.basri.SpringDataJPA.service;

import com.basri.SpringDataJPA.dto.request.DepartmentSaveRequest;
import com.basri.SpringDataJPA.dto.response.DepartmentResponse;
import com.basri.SpringDataJPA.dto.response.HomeResponse;

import java.util.List;

public interface IDepartmentService {
    DepartmentResponse saveDepartment(DepartmentSaveRequest request);
    List<DepartmentResponse> findAll();
}
