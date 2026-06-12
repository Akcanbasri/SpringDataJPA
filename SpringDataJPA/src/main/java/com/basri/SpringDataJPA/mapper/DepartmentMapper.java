package com.basri.SpringDataJPA.mapper;

import com.basri.SpringDataJPA.dto.request.DepartmentSaveRequest;
import com.basri.SpringDataJPA.dto.response.DepartmentResponse;
import com.basri.SpringDataJPA.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    @Mapping(target = "id", ignore = true)
    Department departmentSaveRequestToDepartment(DepartmentSaveRequest request);

    DepartmentResponse departmentToDepartmentResponse(Department department);

    List<DepartmentResponse> departmentToDepartmentResponseList(List<Department> departments);
}

