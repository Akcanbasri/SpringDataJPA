package com.basri.SpringDataJPA.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

}
