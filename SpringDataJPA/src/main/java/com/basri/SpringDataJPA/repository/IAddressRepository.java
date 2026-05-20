package com.basri.SpringDataJPA.repository;

import com.basri.SpringDataJPA.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository  extends JpaRepository<Address, Integer> {
}
