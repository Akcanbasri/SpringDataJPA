package com.basri.SpringDataJPA.repository;

import com.basri.SpringDataJPA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

    // 1. Yöntem: Derived Query Method (İsimden otomatik sorgu üretilir) - IgnoreCase ile büyük/küçük harf duyarsız
    List<Student> findByNameIgnoreCaseAndSurnameIgnoreCase(String name, String surname);

    List<Student> findByNameIgnoreCase(String name);

    List<Student> findBySurnameIgnoreCase(String surname);

    Student findById(int id);

    // 2. Yöntem: JPQL (Java Persistence Query Language - Nesne tabanlı sorgu)
    @Query("SELECT s FROM Student s WHERE s.surname = :surname")
    List<Student> getStudentsBySurname(String surname);

    // 3. Yöntem: Native SQL (Ham SQL sorgusu)
    @Query(value = "SELECT * FROM students ORDER BY id DESC LIMIT 5", nativeQuery = true)
    List<Student> getLastFiveStudents();
}
