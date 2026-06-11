package com.basri.SpringDataJPA.repository;


import com.basri.SpringDataJPA.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}
