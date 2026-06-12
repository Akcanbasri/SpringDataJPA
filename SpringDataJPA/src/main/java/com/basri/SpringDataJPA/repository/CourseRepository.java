package com.basri.SpringDataJPA.repository;

import com.basri.SpringDataJPA.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
