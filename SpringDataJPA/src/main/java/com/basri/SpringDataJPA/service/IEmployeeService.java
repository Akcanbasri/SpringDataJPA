package com.basri.SpringDataJPA.service;

import com.basri.SpringDataJPA.dto.request.EmployeeSaveRequest;
import com.basri.SpringDataJPA.dto.response.EmployeeResponse;

import java.util.List;

public interface IEmployeeService {
    EmployeeResponse saveEmployee(EmployeeSaveRequest request);

    List<EmployeeResponse> findAll();
}
