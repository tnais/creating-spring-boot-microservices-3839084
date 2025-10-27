package com.example.explorecalijpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "STAFF")
@AllArgsConstructor
public class Staff {

    public Staff() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable=false)
    private String surname;

    @Column(nullable = false)
    private String email;

}
