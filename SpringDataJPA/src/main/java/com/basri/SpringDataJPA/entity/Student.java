package com.basri.SpringDataJPA.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "surname", nullable = false, length = 50)
    private String surname;
    @Column(name = "birth_date", nullable = true)
    private LocalDate birthDate;
    @Column(name = "tckNo", nullable = false, unique = true, length = 11)
    private String tckNo;

    @ManyToMany()
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
}
