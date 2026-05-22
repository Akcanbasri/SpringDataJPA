package com.basri.SpringDataJPA.repository;

import com.basri.SpringDataJPA.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomRepository  extends JpaRepository<Room,Integer> {
}
