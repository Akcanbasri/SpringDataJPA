package com.basri.SpringDataJPA.entity;

import jakarta.persistence.*;
import lombok.*;

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
}
