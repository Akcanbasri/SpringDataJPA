package com.basri.SpringDataJPA.service.impl;

import com.basri.SpringDataJPA.dto.request.DepartmentSaveRequest;
import com.basri.SpringDataJPA.dto.response.DepartmentResponse;
import com.basri.SpringDataJPA.entity.Department;
import com.basri.SpringDataJPA.mapper.DepartmentMapper;
import com.basri.SpringDataJPA.repository.IDepartmentRepository;
import com.basri.SpringDataJPA.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImp implements IDepartmentService {

    @Autowired
    private final DepartmentMapper departmentMapper;

    @Autowired
    private final IDepartmentRepository departmentRepository;

    @Override
    public DepartmentResponse saveDepartment(DepartmentSaveRequest request) {

        Department department =
                departmentMapper.departmentSaveRequestToDepartment(request);

        Department savedDepartment =
                departmentRepository.save(department);

        return departmentMapper.departmentToDepartmentResponse(savedDepartment);
    }

    @Override
    public List<DepartmentResponse> findAll() {
      return departmentMapper.departmentToDepartmentResponseList(departmentRepository.findAll());
    }
}