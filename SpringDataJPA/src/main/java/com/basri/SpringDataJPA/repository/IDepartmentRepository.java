package com.basri.SpringDataJPA.repository;

import com.basri.SpringDataJPA.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
}
