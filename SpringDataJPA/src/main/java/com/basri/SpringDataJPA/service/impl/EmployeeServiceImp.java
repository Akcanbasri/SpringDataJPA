package com.basri.SpringDataJPA.service.impl;

import com.basri.SpringDataJPA.dto.request.EmployeeSaveRequest;
import com.basri.SpringDataJPA.dto.response.EmployeeResponse;
import com.basri.SpringDataJPA.entity.Department;
import com.basri.SpringDataJPA.entity.Employee;
import com.basri.SpringDataJPA.mapper.EmployeeMapper;
import com.basri.SpringDataJPA.repository.IDepartmentRepository;
import com.basri.SpringDataJPA.repository.IEmployeeRepository;
import com.basri.SpringDataJPA.service.IEmployeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImp implements IEmployeeService {
    private final IEmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final IDepartmentRepository departmentRepository;

    @Override
    @Transactional
    public EmployeeResponse saveEmployee(EmployeeSaveRequest request) {

        Department department =
                departmentRepository.findById(
                        request.getDepartmentId()
                ).orElseThrow(
                        () -> new RuntimeException("Department not found")
                );

        Employee employee =
                employeeMapper.employeeSaveRequestToEmployee(request);

        employee.setDepartment(department);

        Employee savedEmployee =
                employeeRepository.save(employee);

        return employeeMapper.employeeToEmployeeResponse(savedEmployee);
    }

    @Override
    public List<EmployeeResponse> findAll() {
      return employeeMapper.employeeToEmployeeResponseList(employeeRepository.findAll());
    }
}
