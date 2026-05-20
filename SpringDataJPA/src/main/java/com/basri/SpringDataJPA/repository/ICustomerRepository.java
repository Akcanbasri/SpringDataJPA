package com.basri.SpringDataJPA.repository;

import com.basri.SpringDataJPA.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository  extends JpaRepository<Customer, Integer> {

}
