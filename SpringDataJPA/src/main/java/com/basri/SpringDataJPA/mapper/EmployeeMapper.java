package com.basri.SpringDataJPA.mapper;

import com.basri.SpringDataJPA.dto.request.EmployeeSaveRequest;
import com.basri.SpringDataJPA.dto.response.EmployeeResponse;
import com.basri.SpringDataJPA.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DepartmentMapper.class})
public interface EmployeeMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "department", ignore = true)
    Employee employeeSaveRequestToEmployee(EmployeeSaveRequest request);

    EmployeeResponse employeeToEmployeeResponse(Employee employee);

    List<EmployeeResponse> employeeToEmployeeResponseList(List<Employee> employees);
}